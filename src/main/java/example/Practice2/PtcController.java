package example.Practice2;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class PtcController {
    private final PtcService ptcService;

    // [1] 저장
    @PostMapping("/")
    public boolean testWrite(@RequestBody PtcEntity entity) {
        return ptcService.testWrite(entity);
    }
    
    // [2] 전체조회
    @GetMapping("")
    public List<PtcEntity> testPrint() {
        return ptcService.testPrint();
    }
    
    // [3] 개별조회
    @GetMapping("/detail")
    public Optional<PtcEntity> testDetail(@RequestParam(name = "no") int no) {
        return ptcService.testDetail(no);
    }
    
    
    // [4] 삭제
    @DeleteMapping("")
    public boolean testDelete(@RequestParam(name = "no") int no){
        return ptcService.ptcDelete(no);
    }
    // [5] 수정
    @PutMapping("")
    public boolean testUpdate(@RequestBody PtcEntity entity) {
        return ptcService.ptcUpdate(entity);
    }
    

}
