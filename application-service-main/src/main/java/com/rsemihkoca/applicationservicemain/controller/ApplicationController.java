package com.rsemihkoca.applicationservicemain.controller;

import com.rsemihkoca.applicationservicemain.dto.request.CreateApplicationRequest;
import com.rsemihkoca.applicationservicemain.dto.response.ApplicationResponse;
import com.rsemihkoca.applicationservicemain.dto.response.GenericResponse;
import com.rsemihkoca.applicationservicemain.model.Constants;
import com.rsemihkoca.applicationservicemain.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<GenericResponse<ApplicationResponse>> createApplication(@RequestBody CreateApplicationRequest request) {
        return ResponseEntity.ok(GenericResponse.success(applicationService.createApplication(request)));
    }

    @GetMapping("/{email}")
    public ResponseEntity<GenericResponse<List<ApplicationResponse>>> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(GenericResponse.success(applicationService.getByEmail(email)));
    }

    @GetMapping("/")
    public ResponseEntity<GenericResponse<List<ApplicationResponse>>> getAll() {
        return ResponseEntity.ok(GenericResponse.success(applicationService.getAll()));
    }

    @GetMapping("/errorTest")
    public ResponseEntity<GenericResponse<ApplicationResponse>> testKafka() {
        throw new RuntimeException("test exception");
    }
}
