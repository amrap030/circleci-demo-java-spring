package com.circleci.demojavaspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/version")
public class VersionController {

    private final static String API_VERSION = System.getenv("VERSION");

    @GetMapping
    public ResponseEntity<String> getVersion() {
        return ResponseEntity.ok(API_VERSION);
    }

}
