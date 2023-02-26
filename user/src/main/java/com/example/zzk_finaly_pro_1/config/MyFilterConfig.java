package com.example.zzk_finaly_pro_1.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/myfile/*"})
public class MyFilterConfig implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpSession httpSession = httpServletRequest.getSession();
//
//        if (httpSession.getAttribute("username") == null){
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            response.sendRedirect("/login.html");
//        }else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//        System.out.println("myfilter");

//        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
//        String username = null;
//            for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("mysysUser")){
//                username = cookie.getValue();
//                break;
//            }
////            if (cookie.getName() == "mysysState"){
////                state = cookie.getValue();
////            }
//        }

//        if (username == null){
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            response.sendRedirect("/login.html");
//        }else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }


    }
}
