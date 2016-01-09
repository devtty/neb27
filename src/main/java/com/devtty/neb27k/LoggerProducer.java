package com.devtty.neb27k;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Denis Renning
 */
public class LoggerProducer {
    
    @Produces
    public Logger loggerProducer(InjectionPoint ip){
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
    }
    
}
