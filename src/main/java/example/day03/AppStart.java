package example.day03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 1. 내장 톰캣 지원  2. SpringMVC 지원-> IOC/DI를 이용해 컴포넌트 등록
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);  // 클래스명.class 리플렉션
        // 즉) SpringBoot에 어노테이션을 포함한 정보 실행
         
    }
}
