package example.day04;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// dao가 더 편해진 Repository로 변경
// Service에서 받은것을 리모콘 역할, Entity로 전달
@Repository // 리포지토리(DB조작)담당하는 객체(빈) 등
public interface ExamRepository
    extends JpaRepository< ExamEntity , Integer >{
    // 구현체란? 해당 인터페이스(추상) 구현한 객체
    // <제네릭타입>이란? 해당 클래스내 사용할 매개 타입
    // JpaRepository< 조작할엔티티명 , 엔티티pk타입>
    
}
