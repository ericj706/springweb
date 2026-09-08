package example.practice5.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.practice5.model.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter 
@AllArgsConstructor @NoArgsConstructor 
public class BoardDto {
    private Integer id;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Builder .Default
    private List<CommentDto> commentDtos = new ArrayList<>();

    // 등록
    public BoardEntity toEntity(){
        return BoardEntity.builder()
        .author(this.author)
        .password(this.password)
        .content(this.content)
        .build();
    }
    // 출력
    public static BoardDto from(BoardEntity boardEntity){
        return BoardDto.builder()
        .id(boardEntity.getId())
        .author(boardEntity.getAuthor())
        .content(boardEntity.getContent())
        .createdAt(boardEntity.getCreatedAt())
        .updatedAt(boardEntity.getUpdatedAt())
        .build();
    }
}
