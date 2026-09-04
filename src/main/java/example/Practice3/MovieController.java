package example.Practice3;

import example.Practice3.MovieRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class MovieController {
    @Autowired private MovieService movieService;
    
    // 1. 영화 등록
    @PostMapping("/api/movie")
    public boolean 영화등록(@RequestBody MovieDto movieDto) {        
        return movieService.영화등록(movieDto);
    }
    // 2. 영화 전체조회
    @GetMapping("/api/movie")
    public List<MovieDto> 영화전체조회( ){
        return movieService.영화전체조회( );
    }
    // 3. 영화 개별조회
    @GetMapping("/api/movie")
    public MovieDto 영화개별조회( 
        @RequestParam( name="movieid") int movieid ){
        return movieService.영화개별조회( movieid );
    }
    // 4. 영화수정
    @PutMapping("/api/movie")
    public boolean 영화수정(@RequestBody MovieDto movieDto) {
        return movieService.영화수정(movieDto);
    }
    // 5. 영화삭제
    @DeleteMapping("/api/movie")
    public boolean 영화삭제(
        @PathVariable(name = "movieid") int movieid ){
            return movieService.영화삭제(movieid);
        }
    
}// ce

// 모든거 타이핑하는데까지 10~15분