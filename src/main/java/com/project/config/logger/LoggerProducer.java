package com.project.config.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerProducer {

	private LoggerProducer() {}
	
	@Produces
	public Logger instanceLogger(InjectionPoint ip) {
		return LogManager.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
