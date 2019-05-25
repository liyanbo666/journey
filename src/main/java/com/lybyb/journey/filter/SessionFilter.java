package com.lybyb.journey.filter;

import com.lybyb.journey.util.JsonUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Configuration
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
/**
 * session过滤器
 * @author liyanbo
 */
public class SessionFilter implements Filter {
    //不需要登录就可以访问的路径(比如:注册登录等)
    // String[] includeUrls = new String[]{"/login", "register"};
    private String[] includeUrls={"/doLogin","/register","/getImgCode","/static"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        System.out.println("filter url:" + uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) {
            // 不需要过滤直接传给下一个过滤器
             filterChain.doFilter(request, response);
        } else {
            //需要过滤器
            // session中包含user对象,则是登录状态
            if (session != null && session.getAttribute("user") != null) {
                System.out.println("user:" + session.getAttribute("user"));
                filterChain.doFilter(request, response);
            } else {
                //未登录或登录已失效
                Map<String,String> map=new HashMap<>();
                map.put("code", "201");
                map.put("msg", "登录失败");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(JsonUtil.map2json(map));
            }
            return;
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 是否需要拦截
     * @param uri
     * @return
     */
    public boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if (uri.contains(includeUrl)) {
                return false;
            }
        }
        return true;
    }

}
