package com.example.labsky.controller;

import com.example.labsky.Repository.PassageiroRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlaneController {

    private PassageiroRepository passageiroRepository;
}
