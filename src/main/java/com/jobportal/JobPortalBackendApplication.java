package com.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Automatically scans all sub-packages
public class JobPortalBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobPortalBackendApplication.class, args);
    }
}
