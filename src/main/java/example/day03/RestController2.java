package example.day03;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@Component    // 1. 스프링 컨테이너에 객체(빈) 등록
//@Controller     // 2. HTTP 서블릿 지원 +@Component 포함
@RestController   // 3. 응답 content-type을 application/json 설정 +@Controller
public class RestController2 {
    // 1.
    @GetMapping("/day03/task5")
    public String task5( ) { return "서버에서 응답하는 메시지"; }
    
    // 2.
    @GetMapping("/task6")   // 클래스 내 동일한 URL에 대해서는 @RequestMapping에서 정의한다.
    public int task6( @RequestParam String name , @RequestParam int age ) {
        System.out.println(name);   System.out.println(age);
        return 6;
    }
    
}
