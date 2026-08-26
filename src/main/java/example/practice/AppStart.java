package example.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        // 스프링 실행
        SpringApplication.run( AppStart.class );
        
        // 실행 확인 : http://127.0.0.1:8080
    } // main end 
} // class end 