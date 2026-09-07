package example.Practice4;

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

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
        .enrollId(this.enrollId).status(this.status).build();
    }
    public static EnrollDto from(EnrollDto entity){
        return EnrollDto.builder()
        .enrollId(entity.getEnrollId()).status(entity.getStatus()).build();
    }

    // FK
}
