package com.andurasoftware.alexandria.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ReportBootstrap implements ApplicationListener<ApplicationReadyEvent> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        try{
            System.out.println("ReportBootstrap");
            log.info("ReportBootstrap");
        }catch(Exception e){

            System.out.println("Exceção");

            e.printStackTrace();
        }


    }
}
