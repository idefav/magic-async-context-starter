package com.idefav.magic;

import com.idefav.context.Context;
import com.idefav.magic.filter.AsyncContextFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

/**
 * the AsyncContextConfiguration description.
 *
 * @author wuzishu
 */
public class AsyncContextConfiguration {

    @Bean
    @ConditionalOnClass(Context.class)
    public FilterRegistrationBean<AsyncContextFilter> registrationAsyncContextBean() {
        FilterRegistrationBean<AsyncContextFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new AsyncContextFilter());
        filterFilterRegistrationBean.setOrder(0);
        filterFilterRegistrationBean.setName("async-context-filter");
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.ASYNC, DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.INCLUDE, DispatcherType.REQUEST);
        return filterFilterRegistrationBean;
    }
}
