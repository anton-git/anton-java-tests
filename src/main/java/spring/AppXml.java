package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppXml {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-config.xml");

        System.out.println("Starting displaying beans...");

//        System.out.println(ctx.getApplicationName());
//        System.out.println(ctx.getBean("person"));


        System.out.println("Bean definitions:");
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(e -> System.out.println(" -" + e));

        System.out.println(ctx.getBean("car1"));
        System.out.println(ctx.getBean("car2"));
        System.out.println(ctx.getBean("car3"));
        System.out.println(ctx.getBean("car4"));
//        System.out.println(ctx.getBean("car5"));


    }
}
