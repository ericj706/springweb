package example.day02.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import example.day02.model.dto.BoardDto;
import example.day02.model.dao.BoardDao;


 	
@RestController
public class BoardController {
    private BoardDao bd = BoardDao.getInstance();
    // [1] 등록
    @PostMapping( "/board/save" )
    public boolean save( BoardDto boardDto ){
        boolean result = bd.save(boardDto);
        return result;
    }
} // class end 
