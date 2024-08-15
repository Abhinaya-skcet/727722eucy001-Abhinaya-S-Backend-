package com.example.RestaurantBackend.service.impl;

import com.example.RestaurantBackend.entity.MainCourse;
import com.example.RestaurantBackend.repository.MainCourseRepository;
import com.example.RestaurantBackend.service.MainCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainCourseServiceImpl implements MainCourseService {

    @Autowired
    private MainCourseRepository mainCourseRepository;

    @Override
    public MainCourse addMainCourse(MainCourse mainCourse) {
        return mainCourseRepository.save(mainCourse);
    }

    @Override
    public List<MainCourse> getAllMainCourses() {
        return mainCourseRepository.findAll();
    }
}
