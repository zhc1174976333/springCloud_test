package com.zhc.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TestFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * pre：路由前
     * routing：路由时
     * post：路由后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 根据逻辑判断是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑（过滤器实际做的业务）
     * @return
     */
    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Object token = request.getParameter("token");
        if (null == token || "".equals(token)) {
           requestContext.setSendZuulResponse(false);
           requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
