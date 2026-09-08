package example.practice5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.entity.BoardEntity;
import example.practice5.model.dto.BoardDto;
import example.practice5.model.dto.CommentDto;
import example.practice5.model.repository.BoardRepository;


@Service 
public class BoardService {
    @Autowired private BoardRepository boardRepository;
    
    // 게시글등록
    public boolean 게시글등록(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity(); // dto --> entity 
        BoardEntity savedEntity = boardRepository.save(boardEntity); //save
        if(savedEntity.getId()>=1) return true;  // pk가 존재하면 성공
        return false;
    }

    // 게시글조회
    public List<BoardDto> 게시글조회(){
        List<BoardEntity> boardEntities = boardRepository.findAll(); // 모든 entity , findAll
        List<BoardDto> boardDtos = new ArrayList<>(); // 새로운 dto배열 만들기

        boardEntities.forEach( (boardEntity) -> {
             // 모든 entity -> dto 변환 , 여러번(반복)
            BoardDto boardDto = BoardDto.from(boardEntity); // entity -> dto
             // ** 달린 댓글 포함 **
            boardEntity.getCommentEntities().forEach((commentEntity) -> { 
                CommentDto commentDto = CommentDto.from(commentEntity);
                boardDto.getComments().add(commentDto);
            });
            boardDtos.add(boardDto);
        });
        return boardDtos;
    }

    // 게시글삭제
    public boolean 게시글삭제(Integer id, String password){ // 게시글번호, 비밀번호 매개변수로 전달받기
        // 게시글 번호 이용하여 게시물 정보 조회. --> findbyId
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
        // 게시글번호가 존재하는지 확인
        if (boardEntity != null) {
            // 게시글번호가 존재할때, 비밀번호 가져와서 확인
            if (boardEntity.getPassword().equals(password)) {
                // 게시글 삭제
                boardRepository.deleteById(id); 
                return true;
            }
        }return false;
    }
}
