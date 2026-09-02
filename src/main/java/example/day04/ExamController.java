package example.day04;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




// (1)HTTP통신이 Controller에 들어오면 Service로 전달
@RestController
@RequiredArgsConstructor    // final 멤버변수 생성자 자동생성
public class ExamController {
    // *서비스 (주입받기)불러오기*
    private final ExamService examService;

    // [1] 전체조회
    @GetMapping("/day04/exam")
    public List<ExamEntity> findAll() {
        // 서비스 호출
        return examService.findAll();
    }
    
    // [2] 저장
    @PostMapping("day04/exam")
    public boolean saveAll(@RequestBody ExamEntity entity) {
        // 서비스 호출
        return examService.saveAll(entity);
    }
    
    // [3] 삭제
    @DeleteMapping("/day04/exam")
    public boolean examDelete(@RequestParam(name = "no") int no){
        // 서비스호출
        return examService.examDelete(no);
    }

    // [4] 수정
    @PutMapping("/day04/exam")
    public boolean examUpdate( @RequestBody ExamEntity entity) {
        // 서비스호출
        return examService.examUpdate(entity);
    }
}
