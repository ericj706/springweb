package example.mini;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import example.mini.MemberDto;
import example.mini.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequiredArgsConstructor 
public class MemberController {
    @Autowired private MemberService memberService;

    // 회원가입
    @PostMapping("/blood")
    public boolean mAdd(@RequestBody MemberCreateDto memberDto){
        return memberService.mAdd(memberDto);
    }
    // 전체조회
    @GetMapping("/blood")
    public List<MemberDto> mView() {
        return memberService.mView();
    }
     // 수정
    @PutMapping("")
    public boolean Update( @RequestBody UpdateDto updateDto ){
        return memberService.Update( updateDto );
    }
    
    // 삭제 http://localhost:8080/member?memberId=1
    @DeleteMapping("/member")
    public boolean memberDelete(@RequestParam(name = "memberId") int memberId) {
        return memberService.memberDelete(memberId);
    }
    

}
