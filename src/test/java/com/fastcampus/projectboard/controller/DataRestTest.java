package com.fastcampus.projectboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class DataRestTest {

    private MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc; 
    }
}
