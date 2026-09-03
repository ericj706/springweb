package example.Practice2;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*

    JPA 영속성이란? 자바의 데이터가 사라지지 않게 데이터베이스에 저장
        -> 자바프로그램(휘발성/영구저장x)
*/
@Entity
@Table(name="practice2")
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class PtcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String content;
    private String writer;
}
