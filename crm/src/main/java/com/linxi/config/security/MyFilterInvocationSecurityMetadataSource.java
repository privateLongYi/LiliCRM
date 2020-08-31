package com.linxi.config.security;

import com.linxi.entity.RoleMenu;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置认证数据源，实现动态权限加载（注意：不要手动new，把它交给spring管理，spring默认单例）
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    //权限数据
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    /**
     * 在我们初始化的权限数据中找到对应当前url的权限数据
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        HttpServletRequest request = fi.getRequest();

        //遍历我们初始化的权限数据，找到对应的url对应的权限
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
                .entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    /**
     * 更新权限集合
     */
    public void setRequestMap(List<RoleMenu> roleMenus){
        Map<RequestMatcher, Collection<ConfigAttribute>> map = new ConcurrentHashMap<>();
        for (RoleMenu roleMenu : roleMenus) {
            String mName = roleMenu.getmName();
            if (roleMenu.getmUrl() == null){ continue; }
            for (RoleMenu rm : roleMenus){
                if (rm.getmUrl() == null){ continue; }
                Collection<ConfigAttribute> value = map.get(new AntPathRequestMatcher(rm.getmUrl()));
                if (StringUtils.isEmpty(value)){
                    ArrayList<ConfigAttribute> configs = new ArrayList<>();
                    configs.add(new SecurityConfig(mName));
                    map.put(new AntPathRequestMatcher(rm.getmUrl()), configs);
                } else {
                    value.add(new SecurityConfig(mName));
                }
            }
        }
        this.requestMap = map;
    }
}