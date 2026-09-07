package example.Practice4;

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

    public CourseEntity toEntity(){
        return CourseEntity.builder()
        .courseId(this.courseId).courseName(this.courseName).build();
    }
    public static CourseDto from(CourseDto entity){
        return CourseDto.builder()
        .courseId(entity.getCourseId()).courseName(entity.getCourseName()).build();
    }
}
