package example.day03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Exam_1 {
    public static void main(String[] args) {
        
        SubClass subClass = new SubClass();
        subClass.method1(); // [1]
        subClass.method2(); // [2] 더이상 정의X

        // 1. 리플렉션
        Class<TestClass> clazz = TestClass.class;
        // 2. 특정 메소드를 반환
        try {
            Method method = clazz.getMethod("method3");
            // 3. 메소드의 어노테이션 확인
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            // 4. 어노테이션 속성 확인
            System.out.printf(annotation.value(), annotation.data());
            // 5. 동적로딩: 스프링의 구조
            TestClass testClass = clazz.getDeclaredConstructor().newInstance();
            method.invoke(testClass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}//ce

class SuperClass{void method1(){}}
class subClass extends SuperClass{
    // [1] 오버라이드: 해당 메소드 재정의, 명시
    @Override   void method1(){super.method1();}
    // [2] 어노테이션
    @Deprecated void method2(){}
}

// [3] 어노테이션 만들기
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
@interface MyAnnotation{    // 어노테이션 속성 정의
    String value();
    int data() default 1;   
}
// [4] 어노테이션 주입/사용
// class에 @Retention에 따라 어노테이션이 저장된다 / 
// 어노테이션은 혼자 실행가능한 객체가 아니라 label인셈. 어디에 적용될지는 @Target이 정해줌
class TestClass{
    @MyAnnotation(value = "안녕1", data = 10)
    public void method3(){System.out.println("메소드3 실행");}
    // MyAnnotation에 메소드3 정의
    @MyAnnotation(value = "안녕2")
    public void method4(){System.out.println("메소드4 실행");}
    // 어노테이션에 메소드4
}
