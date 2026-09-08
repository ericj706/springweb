package example.practice5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.practice5.model.dto.BoardDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.service.BoardService;

@RestController 
@RequestMapping ("/api/board")
public class BoardController {
    @Autowired private BoardService boardService;
    // 등록
    @PostMapping ("")
    public boolean 게시물등록(@RequestBody BoardDto BoardDto){
        return boardService.게시물등록(BoardDto);
    }
    // 조회
    @GetMapping ("")
    public List<BoardDto> 게시물조회(){
        return boardService.게시물조회();
    }
    // 삭제
    @DeleteMapping ("")
    public boolean 게시물삭제(
        @RequestParam (name = "id") Integer id,
        @RequestParam (name = "password") String password
    ){ return boardService.게시물삭제(id, password); }

}
