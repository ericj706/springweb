package example.Practice4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice4.model.dto.CourseDto;
import example.Practice4.service.CourseService;

@RestController 
@RequestMapping ("api/course")
public class CourseController {
    @Autowired private CourseService courseService;

    // 등록
    @PostMapping ("")
    public boolean 과정등록(@RequestBody CourseDto courseDto){
        return courseService.과정등록(courseDto);
    }
    // 전체조회
    @GetMapping("")
    public List<CourseDto> 과정전체조회( ){
        return courseService.과정전체조회();
    }

}
