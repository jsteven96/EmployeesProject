package com.example.routingandfilteringgateway.filters.pre;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SimpleFilter extends ZuulFilter {
	
	private Logger logger = LogManager.getLogger(SimpleFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		if (headerNames != null) {
	        while (headerNames.hasMoreElements()) {
	            String name = headerNames.nextElement();
	            logger.info("Request header: " + name + "; Value:" + request.getHeader(name));
	        }
	    }
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
