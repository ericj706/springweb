package example.Practice4.model.dto;

import java.time.LocalDateTime;

import example.Practice4.model.entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder 
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor 
public class EnrollDto {
    private Integer enrollId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // FK로 사용
    private  Integer courseId;
    private Integer studentId;
    // + 과정명,학생명
    private String courseName;
    private String studentName; 

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
        .status(this.status).build();   // 학생FK, 과정FK는 서비스에서 엔티티로 변환
    }
    public static EnrollDto from(EnrollEntity entity){
        return EnrollDto.builder()
        .enrollId(entity.getEnrollId())
        .status(entity.getStatus())
        // 수강엔티티내 과정엔티티 내 과정명만 조회 
        .courseName(entity.getCourseEntity().getCourseName())
        // 수강엔티티내 학생엔티티 내 학생명만 조회
        .studentName(entity.getStudentEntity().getStudentName())
        .build();
    }

    // FK
}
