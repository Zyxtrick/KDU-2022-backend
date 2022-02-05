package com.kd.spring.jdbc;

import com.kd.spring.jdbc.service.ActorService;
import com.kd.spring.jdbc.utils.ObjectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ActorService actorService = context.getBean(ActorService.class);
        Scanner sc = new Scanner(System.in);
        int actorId;
        System.out.println("Actor Id: ");
        actorId = sc.nextInt();

        System.out.println("Get Actor By ID\n");
        System.out.println(ObjectUtils.convertToJson(actorService.getActorById(actorId)));

        String actorName ;
        System.out.println("Actor Name: ");
        actorName = sc.next();

        System.out.println("Get Actor By Name\n");
        System.out.println(ObjectUtils.convertToJson(actorService.getActorByActorName(actorName)));
        System.out.println("Get Film By ActorName\n");
        System.out.println(ObjectUtils.convertToJson(actorService.getFilmByActorName(actorName)));


    }
}
