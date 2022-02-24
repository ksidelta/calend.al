package com.ksidelta.calendal.mock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mock")
public class MockController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
