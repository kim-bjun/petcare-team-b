package com.petcare.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.web.mapper.TimeMapper;

@Service
public class SampleService {

    @Autowired
    private TimeMapper timeMapper;

    public String getName() {
        return "grace";
    }

    public String now() {
        return timeMapper.getTime();
    }
}
