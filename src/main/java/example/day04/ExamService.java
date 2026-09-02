package example.day04;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

// Controller에서 받고 Repository로 전
@Service    // 비즈니스 로직 담당하는 객체(빈)등
@RequiredArgsConstructor
public class ExamService {
    // *리포지토리객체(주입받기) 불러오기*
    private final ExamRepository examRepository;
    
    // [1] 전체조회
    public List<ExamEntity> findAll(){
        // 리포지토리 호출
        // 리포지토리객체.findAll() : (구현체) select 지원
        return examRepository.findAll();
    }

    // [2] 저장
    public boolean saveAll(ExamEntity entity){
        // 리포지토리 호출
        // 리포지토리객체.save(저장할entity): insert 지원
        // save반환값은 영속(매핑/저장)된 엔티티 반환
        ExamEntity saved = examRepository.save(entity);
        // 만약 save된 엔티티가 PK가 존재하면 성공
        if(saved.getEno() >= 1) return true;
        // PK가 없으면 저장 실패
        return false;
    }

    // [3] 삭제
    public boolean examDelete(int no){
        // 리포지토리 호출
        // 리포지토리객체.deleteById(삭제할 PK번호) : delete SQL 지원
        // 리포지토리객체.delete(삭제할 엔티티)
        // 반환타입: 없음, 삭제여부 findxxx 이용하여 확인
        examRepository.deleteById(no);
        return true;
    }
    
    // [4] 수정
    @Transactional
    public boolean examUpdate(ExamEntity entity){
        // 1. 영속된 엔티티 조회[PK: 수정할 번호]
        // 리포지토리객체.findById(조회할pk번호): select SQL 지원
        Optional<ExamEntity> optional = examRepository.findById(entity.getEno());
        // 2. 조회된 결과 엔티티 여부 확인
        // Optional클래스란? 본문(객체) 감싼 클래스 ( 왜? null 예외 안전하게 사용 )
        if(optional.isPresent()){   // 객체가 있으면 true, 없으면 false
            ExamEntity savedEntity = optional.get(); // 래핑된 Optional에서 엔티티 꺼내기
            savedEntity.setEname(entity.getEname());
            return true;
        }                                                                                                                                                                                                                                                                  
        return false;
    }
}
