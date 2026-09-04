package example.day06;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Table(name = "board")
@NoArgsConstructor @AllArgsConstructor @Builder @Data
public class BoardEntity {
    @Id
    private Integer bno;
    private String bname;

    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;
}
