package example.practice5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.dto.CommentDto;
import example.practice5.model.entity.BoardEntity;
import example.practice5.model.entity.CommentEntity;
import example.practice5.model.repository.BoardRepository;
import example.practice5.model.repository.CommentRepository;
import jakarta.transaction.Transactional;


@Service 
public class CommentService {
    @Autowired CommentRepository commentRepository;
    @Autowired private BoardRepository boardRepository;

    // 등록
    @Transactional 
    public boolean 댓글등록(CommentDto commentDto){
        // boardId존재여부확인
        Optional<BoardEntity> boardOptional = boardRepository.findById(commentDto.getBoardId());
        if (boardOptional.isEmpty()) {
            return false;
        }
        CommentEntity commentEntity = commentDto.toEntity();
        commentEntity.setBoardEntity(boardOptional.get());
        CommentEntity savedEntity = commentRepository.save(commentEntity);
        if (savedEntity != null && savedEntity.getCommentId() != null &&savedEntity.getCommentId()>=1) {
            return true;
        }return false;
    }

    // 댓글삭제
    public boolean 댓글삭제(Integer commentId, String password){
        Optional<CommentEntity> optional = commentRepository.findById(commentId);
        if (optional.isPresent()) {
            if (optional.get().getPassword().equals(password)) {
                commentRepository.deleteById(commentId);
                return true;
            }
        }return false;
    }
}
