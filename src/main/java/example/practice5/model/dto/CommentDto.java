package example.practice5.model.dto;

import java.time.LocalDateTime;

import example.practice5.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data 
@AllArgsConstructor @NoArgsConstructor 
public class CommentDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // +FK
    private Integer boardId;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
        .author(this.author)
        .password(this.password)
        .content(this.content)
        .build();
    }
    public static CommentDto from(CommentEntity commentEntity){
        return CommentDto.builder()
        .id(commentEntity.getId())
        .author(commentEntity.getAuthor())
        .password(commentEntity.getPassword())
        .content(commentEntity.getContent())
        .createdAt(commentEntity.getCreatedAt())
        .updatedAt(commentEntity.getUpdatedAt())
        .build();
    }
}
