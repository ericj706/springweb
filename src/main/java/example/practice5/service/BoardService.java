package example.practice5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.dto.BoardDto;
import example.practice5.model.dto.CommentDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.model.repository.BoardRepository;

@Service 
public class BoardService {
    @Autowired private BoardRepository boardRepository;

    // 등록
    public boolean 게시물등록(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        if (savedEntity.getId()>=1) {
            return true;
        }return false;
    }
    // 조회
    public List<BoardDto> 게시물조회(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach((boardEntity)->{
            BoardDto boardDto = BoardDto.from(boardEntity);
            // 댓글목록도 조회
            boardEntity.getCommentEntities().forEach((commentEntity)->{
                CommentDto commentDto = CommentDto.from(commentEntity);
                // boardDto에 commentDto 추가
                boardDto.getComments().add(commentDto);
            });
            boardDtos.add(boardDto);
        });
        return boardDtos;
    }
    // 식제
    public boolean 게시물삭제(Integer id, String password){
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
        if (boardEntity != null) {
            if (boardEntity.getPassword().equals(password)) {
                boardRepository.deleteById(id);
                return true;
            }
        }return false;
    }
    
}//ce
