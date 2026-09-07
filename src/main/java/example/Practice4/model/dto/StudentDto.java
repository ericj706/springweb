package example.Practice4.model.dto;

import java.time.LocalDateTime;

import example.Practice4.model.entity.StudentEntity;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
        .studentName(this.studentName).build();
    }
    public static StudentDto from(StudentEntity entity){
        return StudentDto.builder()
        .studentId(entity.getStudentId())
        .studentName(entity.getStudentName())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    }

    // FK
}