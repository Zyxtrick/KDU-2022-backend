package com.kd.spring.jdbc;

import com.kd.spring.jdbc.service.ActorService;
import com.kd.spring.jdbc.utils.ObjectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ActorService service=context.getBean("usingActorJpa",ActorService.class);
        System.out.println(ObjectUtils.convertToJson(service.getActorByFirstName("ewan")));
        System.out.println(ObjectUtils.convertToJson(service.getActorByLastName("jayne")));
        System.out.println(ObjectUtils.convertToJson(service.getActorById(6)));

    }
}
