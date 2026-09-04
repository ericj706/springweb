package example.day06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity@Table(name = "category")
@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class CategoryEntity {
    @Id
    private Integer cno;
    private String cname;
    // 양방향 참조
    @OneToMany( mappedBy = "categoryEntity") // 하나가 다수 참조
    @ToString.Exclude
    @Builder.Default    
    private List<BoardEntity> boardList = new ArrayList<>();


}
