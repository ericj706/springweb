package example.Practice4.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice4.model.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder 
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor 
public class CourseDto {
    private Integer courseId;
    private String courseName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // +학생목록
    private List<StudentDto> studentDtos = new ArrayList<>();
    
    // 과정 등록
    public CourseEntity toEntity(){
        return CourseEntity.builder()
        .courseName(this.courseName).build();
    }
    // 과정 전체 출력
    public static CourseDto from(CourseEntity entity){
        return CourseDto.builder()
        .courseId(entity.getCourseId())
        .courseName(entity.getCourseName())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    }
}
