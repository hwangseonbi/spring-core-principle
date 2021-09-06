package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        /*
         * 컴포넌트 스캔을 했을 때 Bean으로 등록하지 않을 것을 찾는다.
         * Configuration안에는 Component가 붙어있다.
         * 실무에서는 굳이 이렇게 안한다.
         * 예제코드 살리기위해서 이렇게 한것.
        */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
