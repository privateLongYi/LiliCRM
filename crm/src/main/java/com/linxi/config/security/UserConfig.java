package com.linxi.config.security;

import com.linxi.entity.RoleMenu;
import com.linxi.service.IRoleMenuService;
import com.linxi.service.IUserService;
import com.linxi.service.impl.RoleMenuService;
import com.linxi.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class UserConfig implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户
        com.linxi.entity.User user = iUserService.findByLoginName(username);
        //查询权限
        List<RoleMenu> roleMenus = iRoleMenuService.queryRoleMenuByRoleId(user.getuRoleId());
        //查无此用户
        if(user == null){
            user.setuName("查无此用户");
            user.setuPassword("查无此用户");
        }
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new User(user.getuName(), user.getuPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(roleMenus.toString()));
    }
}
