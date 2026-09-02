package example.Practice1;

import java.util.ArrayList;

import javax.crypto.spec.DESKeySpec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController // @ResponseBody(응답HTTP content-type을 json으로 자동 변환) + @Controller
// 뷰 변환: 주로@Controller, 값 반환: RestController 
@RequestMapping("/test")
public class TestController {
    // [1]게시물등록
    @PostMapping("/")
    public boolean testWrite(@RequestBody TestDto testDto) {
        System.out.println("TestController.testWrite()");
        return true;
    }
    
    // [2] 조회
    @GetMapping("")
    public ArrayList<TestDto> testPrint() {
        System.out.println("TestController.testPrint()");
        ArrayList<TestDto> list = new ArrayList<>(); 
        list.add(new TestDto(1, "안녕하세요1","유재석"));
        list.add(new TestDto(2, "안녕하세요2","강호동"));
        return list;
    }
    @GetMapping("/detail")
    public TestDto testDetail(@RequestParam(name ="no") int no) {
        System.out.println("TestController.testDetail()");
        return new TestDto(1, "안녕하세요1", "유재석");
    }

    // [3] 삭제
    @DeleteMapping("/{no}")
    public boolean testDelete(@PathVariable(name="no") int no){
        return true;
    }

    // [4] 수정
    @PutMapping("")
    public boolean testUpdate(@RequestBody TestDto testDto) {
        return true;
    }
}
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
class TestDto{
    private int no; 
    private String content; 
    private String writer;
}
