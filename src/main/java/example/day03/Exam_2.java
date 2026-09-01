package example.day03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Exam_2 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("유재석", 100, 70);
        // @Setter
        s1.setKor(100);
        s2.setMath(70);
        // @Getter
        System.out.println(s2.getKor());
        // @ToString
        System.out.println(s2.toString());
        // @Builder 빌더패턴
        Student s3 = Student.builder()
                            .kor(90)
                            .name("강호동")
                            .build();
                            // 클래스명.builder().build();
    }
}

@NoArgsConstructor // 매개변수 없는 생성자 자동생성
@AllArgsConstructor// 전체 매개변수있는 생성자 자동생성

@Getter @Setter
@ToString
@Data   // getter+setter+RequiredArgsConstructor+toString 묶음
@EqualsAndHashCode 
@Builder

class Student{  // 멤버변수, 생성자, getter,setter
    private String name;
    private int kor;
    private int math;

}