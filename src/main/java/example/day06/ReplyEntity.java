package example.day06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity@Table(name = "reply")
@NoArgsConstructor @AllArgsConstructor@Builder@Data
public class ReplyEntity {
    @Id
    private Integer rno;
    private String rname;
    // 단방향
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="bno")
    private BoardEntity boardEntity;
    // 양방향
   /*  @OneToMany(mappedBy = "boardEntity")
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyList = new ArrayList<>();
*/
}

/* 
    영속성이란? 자바는 영구저장이 불가능 하므로 DB매핑/연결하여 영속성(영구저장) 표현
        - Entity entity = new entity();  // 객체
        - repository.save(), repository.findAll(), repository.findById() 등등 결과 영속된
        - 
    @ManyToOne(cascade = 영속성 제약조건, fetch = 불러오기시기)
        CascadeType.Remove
        Cascade.Merge
        Cascade.Derach
*/