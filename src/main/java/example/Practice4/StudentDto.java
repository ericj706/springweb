package example.Practice4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder 
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor 
public class StudentDto {
    private Integer studentId;
    private String studentName;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
        .studentId(this.studentId).studentName(this.studentName).build();
    }
    public static StudentDto from(StudentDto entity){
        return StudentDto.builder()
        .studentId(entity.getStudentId()).studentName(entity.getStudentName()).build();
    }

    // FK
}