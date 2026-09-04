package example.day06;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Exam {
    // [1] '자유'카테고리 등록
    Category c1 = new Category(1, "자유");
    // [2] '자유'카테고리에 게시물 작성
    Board b1 = new Board(1, "제목1", c1);
}

@Data @AllArgsConstructor
class Board{
    private int bno;
    private String btitle;
    private Category category;
}
@Data @AllArgsConstructor
class Category{ // 카테고리 상위테이블: 
    private int cno;
    private String cname;   
}
