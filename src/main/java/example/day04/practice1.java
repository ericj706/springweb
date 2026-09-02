package example.day04;

import javax.crypto.spec.DESKeySpec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;


@Controller
public class practice1 {
    @GetMapping(value = "/day04/test")
    @ResponseBody
    public TestDto test( ) {
        TestDto dto = new TestDto(); 
        dto.setNo(1); dto.setContent("안녕하세요1"); dto.setWriter("유재석");
        dto.setNo(2); dto.setContent("안녕하세요2"); dto.setWriter("강호동");
        return dto;
    }
    @GetMapping(value = "/day04/test/detail")
    public int test(
        @PathVariable(no="no") int no,
        @PathVariable(content="content") String content,
        @PathVariable(writer="writer") String writer
    ) {
        System.out.println(no);
        System.out.println(content);
        System.out.println(writer);
    }
}
@Data
class TestDto{int no; String content; String writer;}