package example.day04;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
