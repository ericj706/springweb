package example.mini;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.transaction.Transactional;

@Service
public class MemberService {
    @Autowired MemberRepository memberRepository;

    // 회원가입
    public boolean mAdd(MemberCreateDto memberDto){
        MemberEntity memberEntity = memberDto.toEntity();
        MemberEntity savedEntity = memberRepository.save(memberEntity);
        if(savedEntity.getMember_id() >= 1){return true;}
        return false;
    }
    
    // 회원 전체조회
    public List<MemberDto> mView(){
        List<MemberEntity> entities = memberRepository.findAll();
        List<MemberDto> list = new ArrayList<>();
        entities.forEach( (entity) -> {
            MemberDto dto = MemberDto.from(entity);
            list.add(dto);
        });
        return list;
    }
    // 수정
    @Transactional
    public boolean Update( UpdateDto updateDto ) {
        MemberEntity memberEntity = updateDto.toEntity();
        Optional<MemberEntity> optional = memberRepository.findById(updateDto.getMember_id());
        if(optional.isPresent()) {
            MemberEntity savedEntity = optional.get();
            savedEntity.setCreated_at(memberEntity.getCreated_at());
            savedEntity.setMember_type(memberEntity.getMember_type());
            savedEntity.setName(memberEntity.getName());
            savedEntity.setPassword(memberEntity.getPassword());
            savedEntity.setPhone(memberEntity.getPhone());
            return true;
        }
        return false;
    }
    @Transactional
    public boolean memberDelete(int memberId) {
        System.out.println("MemberService.memberDelete()");
        System.out.println( memberId );
        Optional<MemberEntity> optional = memberRepository.findById(memberId);
        if (optional.isPresent()) {
            MemberEntity memberEntity = optional.get();
            memberRepository.delete(memberEntity);
            return true;
        }
        return false;
    }

} //ce
