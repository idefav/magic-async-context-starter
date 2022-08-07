package com.idefav.magic.filter;

import com.idefav.context.Context;
import com.idefav.context.Scope;
import com.idefav.context.request.RequestHolder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * the AsyncContextFilter description.
 *
 * @author wuzishu
 */
public class AsyncContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            try (Scope ignore = RequestHolder.set((HttpServletRequest) request)) {
                chain.doFilter(request, response);
            }
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
