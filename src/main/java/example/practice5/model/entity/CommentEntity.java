package example.practice5.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "comment")
@Builder @Data @AllArgsConstructor @NoArgsConstructor 
public class CommentEntity extends BaseTime{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column (length = 10)
    private String author;
    @Column (length = 50)
    private String password;
    @Column (length = 100)
    private String content;

    @JoinColumn(name = "board_id")
    @ManyToOne 
    private BoardEntity boardEntity;



}
