package com.linxi.controller;


import com.linxi.util.DataResult;
import com.linxi.util.ImageCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author LongYi
 * @create 2020/7/31 20:03
 */
@RestController
@RequestMapping("imageCode")
@Api(value = "验证码控制类", tags = "验证码控制类")
@Slf4j
public class ImageCodeController {

    @GetMapping("getVerify")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            ImageCodeUtil randomValidateCode = new ImageCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            log.error("生成验证码失败");
        }
    }

    @PostMapping("checkVerify")
    @ApiOperation(value = "检查验证码", notes = "检查验证码")
    public DataResult checkVerify(@RequestParam @ApiParam(name = "imageCode", value = "验证码",
            required = true) String imageCode, HttpSession session) {
        //从session中获取随机数
        Object random = session.getAttribute(ImageCodeUtil.IMAGE_RANDOM_CODEKEY);
        System.out.println("random:"+String.valueOf(random)+"   imageCode:"+imageCode);
        if (random != null && String.valueOf(random).equals(imageCode)) {
            return new DataResult().ok();
        }
        return new DataResult().fail("验证码输入有误");
    }

}
