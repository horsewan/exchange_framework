package com.zwan.bitrade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.zwan.bitrade.ext.SmartHttpSessionStrategy;


@EnableRedisHttpSession
public class HttpSessionConfig {
	 
	 @Bean
	 public HttpSessionStrategy httpSessionStrategy(){
		 HeaderHttpSessionStrategy headerSession = new HeaderHttpSessionStrategy();
		 CookieHttpSessionStrategy cookieSession = new CookieHttpSessionStrategy();
		 headerSession.setHeaderName("x-auth-token");
		 return new SmartHttpSessionStrategy(cookieSession,headerSession);
	 }
}
