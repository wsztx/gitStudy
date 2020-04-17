package com.ztx.study.anniotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JunitTest {

    @Test
    public void testImport(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = ctx.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }
}
