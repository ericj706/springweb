package example.day05;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "test")
@AllArgsConstructor @NoArgsConstructor @Builder
@Setter @Getter @ToString
public class TestEntity extends BaseTime{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column( name="name", nullable = false, length = 100, unique = true)
    private String name; // 이름

    @Column( columnDefinition = "varchar(100) not null default '제품설명'" )
    private String descri; // 설명
    
    @Column( insertable = true, updatable = true)
    private Integer price; // 가격
/*
    @Column( name="필드명" ): 생략시 자동으로 멤버변수명 지정
    @Column( nullable = true/false ): not null
    @Column( length = "문자열길이~255" )  = varchar()
    @Column( unique = true ) : 중복 불가능 / 가능
    @Column( columnDefinition = "SQL구문" )
    @Column( insertable = "인설트여부 true/false", updatable = true )

*/

}
