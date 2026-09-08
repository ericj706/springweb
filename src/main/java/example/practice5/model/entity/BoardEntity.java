package example.practice5.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @Builder 
@AllArgsConstructor @NoArgsConstructor 
@Table (name = "board")
public class BoardEntity extends BaseTime{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @OneToMany (mappedBy = "boardEntity", cascade = CascadeType.ALL)
    @ToString .Exclude
    @Builder .Default
    private List<CommentEntity> commentEntities = new ArrayList<>();

}
