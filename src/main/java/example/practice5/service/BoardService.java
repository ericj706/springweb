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
import org.springframework.transaction.annotation.Transactional;

@Service 
public class BoardService {
    @Autowired BoardRepository boardRepository;
    
    // 게시글등록
    @Transactional 
    public boolean 게시글등록(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        return savedEntity.getBoardId() != null && savedEntity.getBoardId()>=1;
    }

    // 게시글조회
    @Transactional(readOnly=true)
    public List<BoardDto> 게시글조회(){
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();

        boardEntities.forEach(boardEntity -> {
            // 게시글 Entity를 BoardDto로 변환
            BoardDto boardDto = BoardDto.from(boardEntity);
            
            // 해당 게시글의 댓글들을 CommentDto로 변환해서 담기
            List<CommentDto> commentDto1 = new ArrayList<>();
            boardEntity.getCommentEntities().forEach(commentEntity -> {
                CommentDto commentDto2 = CommentDto.from(commentEntity);
                commentDto1.add(commentDto2);
            });
            
            boardDto.setCommentDtos(commentDto1);
            boardDtos.add(boardDto);
        });
        return boardDtos;
    }

    // 게시글삭제
    @Transactional 
    public boolean 게시글삭제(Integer boardId, String password){
        Optional<BoardEntity> optional = boardRepository.findById(boardId);

        if (optional.isPresent()) {
            BoardEntity boardEntity = optional.get();
            if (boardEntity.getPassword().equals(password)) {
                boardRepository.delete(boardEntity); 
                return true;
            }
        }return false;
    }
}
