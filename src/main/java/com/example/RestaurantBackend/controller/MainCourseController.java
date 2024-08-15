package com.example.RestaurantBackend.controller;

import com.example.RestaurantBackend.entity.MainCourse;
import com.example.RestaurantBackend.service.MainCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/main-courses")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the URL if necessary
public class MainCourseController {

    @Autowired
    private MainCourseService mainCourseService;

    @PostMapping
    public ResponseEntity<MainCourse> addMainCourse(@RequestBody MainCourse mainCourse) {
        MainCourse createdMainCourse = mainCourseService.addMainCourse(mainCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMainCourse);
    }

    @GetMapping
    public ResponseEntity<List<MainCourse>> getAllMainCourses() {
        List<MainCourse> mainCourses = mainCourseService.getAllMainCourses();
        return ResponseEntity.ok(mainCourses);
    }
}
