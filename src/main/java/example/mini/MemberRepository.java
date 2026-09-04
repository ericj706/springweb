package example.mini;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends JpaRepository<MemberEntity, Integer>{

}
