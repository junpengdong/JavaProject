package com.baoqilai.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理spring MVC 跨域问题
 */
public class MVCRequestMappingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(request, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
