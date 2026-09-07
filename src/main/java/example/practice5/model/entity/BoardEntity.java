package example.practice5.model.entity;

import java.util.ArrayList;
import java.util.List;

import example.practice5.model.dto.CommentDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

@Entity 
@Table (name = "board")
@Builder @Data @AllArgsConstructor @NoArgsConstructor 
public class BoardEntity extends BaseTime{
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer boardId;
    @Column (length = 10)
    private String author;
    @Column (length = 50)
    private String password;
    @Column (length = 100)
    private String content;

    @OneToMany (mappedBy = "boardEntity", cascade = CascadeType.ALL)
    @ToString .Exclude
    @Builder .Default
    private List<CommentEntity> commentEntities = new ArrayList<>();
    
}
