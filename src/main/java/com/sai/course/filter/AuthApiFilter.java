package com.sai.course.filter;

import com.sai.course.component.RouterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthApiFilter extends GenericFilterBean {

    @Autowired
    private RouterValidator routerValidator;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String reqURL = getCurrentUrlFromRequest(request);
        if(reqURL != null && !routerValidator.isSecured.test(reqURL)) {
            // System.out.println("not secured url:"+reqURL);
        } else if (req.getHeader("id") == null || req.getHeader("username") == null
                || req.getHeader("authorities") == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setContentType("application/json");
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not Authorized in the request");
            return;
        }
        chain.doFilter(request, response);
    }

    public String getCurrentUrlFromRequest(ServletRequest request)
    {
        String url = null;
        if (request instanceof HttpServletRequest) {
            url = ((HttpServletRequest)request).getRequestURL().toString();
        }
        return url;
    }
}
