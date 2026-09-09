package example.practice5.model.entity;

import java.time.LocalDateTime;

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

@Entity @Data @Builder 
@AllArgsConstructor @NoArgsConstructor 
@Table (name = "comment")
public class CommentEntity extends BaseTime{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String password;
    private String content;

    @JoinColumn (name = "board_id")
    @ManyToOne
    private BoardEntity boardEntity;

    
}
