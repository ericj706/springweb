package example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

public class Exam_3 {

}

// [1] 전통방식 객체 생성, dao 인스턴스 생성
class SampleDao{void method(){System.out.println("메소드실행");}}
class SampleController1{
    void method(){  // 메소드
        SampleDao sampleDao = new SampleDao();
        sampleDao.method(); 
    }
}

// [2] 전통방식 싱글톤 생성, dao 인스턴스 생성 불가능
class SampleDao2{
    private SampleDao2(){}
    private static final SampleDao2 instance = new SampleDao2();
    public static SampleDao2 getInstance(){return instance;}
    public void method2(){}
}
class SampleController2{
    SampleDao2 dao2 = SampleDao2.getInstance();
    void method(){
        dao2.method2();
    }
}

// [3] 스프링 IOC/DI
@Component  // 싱글톤 대신에 자동객체관리IOC 규칙으로 스프링 컨테이너에 자동 객체생성
class SampleDao3{
    void method(){}
}
// 1) 의존성 주입, 객체 가져와서 대입
class SampleController3{
    @Autowired
    private SampleDao3 dao3;
    void method(){
        dao3.method();
    }
}

// 2) 스프링에서 가장 권장하는 방법, final 생성자
class SampleController4{
    private final SampleDao3 dao3;
    @Autowired
    public SampleController4(SampleDao3 dao3){
        this.dao3=dao3;
    }
    void method(){
        dao3.method();
    }
}
@RequiredArgsConstructor
class SampleController5{
    private final SampleDao3 dao3;
}

