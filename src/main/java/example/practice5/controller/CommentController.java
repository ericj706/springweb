package example.practice5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.practice5.model.dto.CommentDto;
import example.practice5.service.CommentService;

@RestController 
@RequestMapping ("/api/board")
public class CommentController {
    @Autowired private CommentService commentService;

    // 댓글 등록
    @PostMapping ("/comments")
    public boolean 댓글등록(@RequestBody CommentDto commentDto){
        return commentService.댓글등록(commentDto);
    }

    // 댓글 삭제
    @DeleteMapping ("//{comment_id}/{password}")
    public boolean 댓글삭제(
        @PathVariable (name = "comment_id") Integer commentId,
        @PathVariable (name = "password") String password
        ){
            return commentService.댓글삭제(commentId,password);
        }
    

}
