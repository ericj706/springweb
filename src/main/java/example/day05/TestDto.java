package example.day05;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor@AllArgsConstructor@Builder
@Getter@Setter@ToString
public class TestDto extends BaseTime{  // 서로 계층간 이동객체( Controller에서는 엔티티 사용금지 )
    // 엔티티와 동일하게 멤버변수 구성: 기능별로 DTO 구성 (등록DTO, 조회DTO, 수정DTO)
    private Integer no;
    private String name;
    private String descri;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateTime;
    // DTO --> ENTITY함수 : C -> S( D -> E )
    // ENTITY --> DTO함수 : S -> C( E -> D )
    public TestEntity toEntity( ){
        return TestEntity.builder() // 빌더패턴이란? new(생성자) 대신에 객체생성을 메소드 방식 지원
                .name(this.name)
                .descri(this.descri)
                .price(this.price)
                .build();
    }   
    public static TestDto from(TestEntity testEntity){
        return TestDto.builder()
                .name(testEntity.getName())
                .descri(testEntity.getDescri())
                .price(testEntity.getPrice())
                .createDate(testEntity.getCreateDate())
                .updateTime(testEntity.getUpdateDate())
                .build();
    }

}
