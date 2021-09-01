package com.example.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA라고 가정 : 사용자A가 10000원 주문
        int userAPrice = statefulService1.order("userA",10000);

        //ThreadB라고 가정 : 사용자B가 20000원 주문
        int userBPrice = statefulService2.order("userB",20000);


        //ThreadA : 사용자A가 주문 금액 조회
        System.out.println("userAPrice = " + userAPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);
        Assertions.assertThat(userBPrice).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}