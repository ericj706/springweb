package example.Practice4.model.entity;

import java.util.ArrayList;
import java.util.List;

import example.Practice4.model.dto.CourseDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table (name = "course")
@Builder @Data  @AllArgsConstructor @NoArgsConstructor 
public class CourseEntity extends BaseTime{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    @Column(length = 20)
    private String courseName;

    // @OneToMany( mappedBy = "매핑할 멤버 변수명")
    @OneToMany(mappedBy = "courseEntity", cascade = CascadeType.ALL , fetch = FetchType.LAZY) 
    @ToString .Exclude  // 순환참조방지
    @Builder.Default    // 빌더패턴 사용시 초기값 사용
    private List<EnrollEntity> enrollEntities = new ArrayList<>();
}
