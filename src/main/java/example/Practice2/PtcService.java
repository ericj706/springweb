package example.Practice2;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PtcService {
    private final PtcRepository2 ptcRepository2;
    
    // [1] 저장
    public boolean testWrite(PtcEntity entity){
        PtcEntity saved = ptcRepository2.save(entity);
        if(saved.getNo()>=1) return true;
        return false;
    }
    // [2] 전체조회
    public List<PtcEntity> testPrint(){
        return ptcRepository2.findAll();
    }
    // [3] 개별조회
    // public Optional<PtcEntity> testDetail(int no) {
    //     return ptcRepository2.findById(no);
    // }
    public PtcEntity testDetail( int no ){
    Optional<PtcEntity> optional = ptcRepository2.findById( no );
    if( optional.isPresent() ){
        PtcEntity entity = optional.get(); 
        return entity;
    }
    return null; // 객체가 없다는 뜻이 null
    }

    // [4] 삭제
    public boolean ptcDelete(int no){
        ptcRepository2.deleteById(no);
        return true;
    }
    // [5] 수정
    @Transactional
    public boolean ptcUpdate(PtcEntity entity){
        Optional<PtcEntity> optional = ptcRepository2.findById(entity.getNo());
        if(optional.isPresent()){   // 객체가 있으면 true, 없으면 false
            PtcEntity savedEntity = optional.get(); // 래핑된 Optional에서 엔티티 꺼내기
            savedEntity.setContent(entity.getContent());
            savedEntity.setWriter(entity.getWriter());
            return true;
        }                                                                                                                                                                                                                                                                  
        return false;
    }
}

