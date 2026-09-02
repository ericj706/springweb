package example.Practice2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PtcRepository2
    extends JpaRepository< PtcEntity , Integer >{
    
}
