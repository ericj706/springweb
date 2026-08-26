package example.practice.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import example.practice.model.dao.BoardDao;
import example.practice.model.dto.BoardDto;

@RestController //
public class BoardController {
    private BoardDao bd = BoardDao.getInstance();

    // [1] 등록
    @PostMapping( "/board/save" )
    public boolean save( BoardDto boardDto ){
        boolean result = bd.save(boardDto);
        return result;
    }

    // [2] 전체조회
    @GetMapping( "/board/findall" )
    public ArrayList<BoardDto> findAll( ){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }

    // [3] 개별수정 Controller
    @PutMapping( "/board/update" )
    public boolean update( BoardDto boardDto ){
        return bd.update( boardDto );
    }
    // [4] 개별삭제 Controller
    @DeleteMapping( "/board/delete" )
    public boolean delete( String phone ){
        return bd.delete( phone );
    }
}
