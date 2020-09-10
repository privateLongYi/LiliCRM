package com.linxi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.linxi.entity.RoleMenu;
import com.linxi.entity.User;
import com.linxi.service.IRoleMenuService;
import com.linxi.service.IUserService;
import com.linxi.util.ErrorUtil;
import com.linxi.util.RsaUtil;
import com.linxi.util.SecurityUtil;
import com.linxi.util.VerifyCodeImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@MapperScan("com.linxi.mapper")
@Slf4j
@EnableAsync//开启异步调用
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class CrmApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext application = SpringApplication.run(CrmApplication.class, args);

		Environment env = application.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Login: \thttp://{}:{}/LiLiCRM/loginPage\n\t" +
						"Doc: \thttp://{}:{}/LiLiCRM/doc.html\n" +
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));
	}

    /**
     * 解决不能注入session注册表问题
     */
    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}

@Slf4j
@Controller
@RequestMapping("/")
@Configuration
class IndexController {

	/**
	 * 用户服务对象
	 */
	@Autowired
	private IUserService iUserService;

	/**
	 * 菜单服务对象
	 */
	@Autowired
	private IRoleMenuService iRoleMenuService;

	/**
	 * 端口
	 */
	@Value("${server.port}")
	private String port;

	/**
	 * 跳转登录页面
	 */
	@GetMapping("loginPage")
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView("login");

		//后端公钥
		String publicKey = RsaUtil.getPublicKey();
		log.info("后端公钥：" + publicKey);
		modelAndView.addObject("publicKey", publicKey);

		return modelAndView;
	}

	/**
	 * 跳转首页
	 */
	@GetMapping("")
	public void index1(HttpServletResponse response){
		//内部重定向
		try {
			response.sendRedirect("/index");
		} catch (IOException e) {
			//输出到日志文件中
			log.error(ErrorUtil.errorInfoToString(e));
		}
	}
	@GetMapping("index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("index");

		//登录用户
		User user = iUserService.findByLoginName(SecurityUtil.getLoginUser().getUsername());
		user.setuPassword(null);//隐藏部分属性
		modelAndView.addObject( "user", user);

		//登录用户菜单
		List<RoleMenu> roleMenus = iRoleMenuService.queryRMByRId(user.getuRoleId());
		modelAndView.addObject("roleMenus",roleMenus);

		//后端公钥
		String publicKey = RsaUtil.getPublicKey();
		log.info("后端公钥：" + publicKey);
		modelAndView.addObject("publicKey", publicKey);
		return modelAndView;
	}

	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@RequestMapping("getVerifyCodeImage")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getOutputStream();
		String verifyCode = VerifyCodeImageUtil.generateTextCode(VerifyCodeImageUtil.TYPE_NUM_UPPER, 4, null);

		//将验证码放到HttpSession里面
		request.getSession().setAttribute("verifyCode", verifyCode);
		log.info("本次生成的验证码为：" + verifyCode + ",已存放到HttpSession中");

		//设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeImageUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);

		//写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

}

