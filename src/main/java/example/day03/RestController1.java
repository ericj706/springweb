package example.day03;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;


//@Component
@Controller // [서블릿대신] HTTP 통신 지원하는 서블릿 제공 + @Component
public class RestController1 {
    // 1. http://localhost:8080/day03/task1
    @GetMapping(value = "/day03/task1") // HTTP 요청: url 매핑 / 연결
    @ResponseBody // HTTP 응답: JSON타입변환
    public int task1(){
        System.out.println("RestController1.task1()");  // soutm+엔터: 현재 메소드명
        return 10;
    }
    
    // 2. 
    @GetMapping("/day03/task2") // HTTP 요청: url 매핑 / 연결
    @ResponseBody // HTTP 응답: JSON타입변환
    public String task2(){
        System.out.println("RestController1.task2()");  // soutm+엔터: 현재 메소드명
        return "안녕하세요";
    }
    
    // 3.
    @GetMapping("/day03/task3") // HTTP 요청: url 매핑 / 연결
    @ResponseBody // HTTP 응답: JSON타입변환
    public Map<String,Object> task3(){
        Map<String,Object> map = new HashMap<>();
        map.put("유재석", 100);
        map.put("강호동", 90);
        return map;
    }
    
    // 4. 
    @GetMapping(value = "/day03/task4") // HTTP 요청: url 매핑 / 연결
    @ResponseBody // HTTP 응답: JSON타입변환
    public ExamDto task4(){
        ExamDto dto = new ExamDto();    dto.setName("유재석"); dto.setAge(10);
        return dto;
    }
    
}
// dto
@Data // 롬복
class ExamDto{String name; int age;}
/*
    @ResoponseBody 란? 자바의 타입 --> HTTP content-type 변환하여 동일하게 사용/직렬화
    - String : text / plain ;
    - 그 외: APplication / json
*/