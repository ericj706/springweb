package example.practice5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.practice5.model.dto.CommentDto;
import example.practice5.model.entity.CommentEntity;
import example.practice5.model.repository.CommentRepository;

@Service 
public class CommentService {
    @Autowired CommentRepository commentRepository;

    // 등록
    public boolean 댓글등록(CommentDto commentDto){
        CommentEntity commentEntity = commentDto.toEntity();
        CommentEntity savedEntity = commentRepository.save(commentEntity);
        if (savedEntity.getCommentId()>=1) {
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
