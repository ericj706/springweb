package example.practice5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.dto.CommentDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.model.entity.CommentEntity;
import example.practice5.model.repository.BoardRepository;
import example.practice5.model.repository.CommentRepository;

@Service 
public class CommentService {
    @Autowired private CommentRepository commentRepository;
    @Autowired private BoardRepository boardRepository;

    // 댓글등록
    public boolean 댓글등록(CommentDto commentDto){
        CommentEntity commentEntity = commentDto.toEntity();    // dto -> entity
        //boardId
        BoardEntity boardEntity = boardRepository.findById(commentDto.getBoardId()).orElse(null);
        commentEntity.setBoardEntity(boardEntity);
        CommentEntity savedEntity = commentRepository.save(commentEntity);
        if (savedEntity.getId() >= 1) {
            return true;
        }
        return false;
    }
    // 댓글삭제
    public boolean 댓글삭제(Integer id, String password){
        BoardEntity boardEntity = boardRepository.findById(id).orElse(null);
        if (boardEntity != null) {
            if (boardEntity.getPassword().equals(password)) {
                boardRepository.deleteById(id);
                return true;
            }
        }return false;
    }
}
