package com.example.RestaurantBackend.service;

import com.example.RestaurantBackend.entity.MainCourse;

import java.util.List;

public interface MainCourseService {
    MainCourse addMainCourse(MainCourse mainCourse);
    List<MainCourse> getAllMainCourses();
}
