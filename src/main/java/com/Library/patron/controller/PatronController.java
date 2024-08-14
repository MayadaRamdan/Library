package com.Library.patron.controller;

import com.Library.common.ApiResponse;
import com.Library.patron.dto.PatronDto;
import com.Library.patron.service.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    PatronService patronService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllPatron() {
        List<PatronDto> allPatron = patronService.getAllPatron();
        return ResponseEntity.ok(ApiResponse.ok(allPatron));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getPatron(@PathVariable(name = "id") Long patronId) {
        PatronDto patronDto =patronService.getAPatron(patronId);
        return ResponseEntity.ok(ApiResponse.ok(patronDto));

    }


    @PostMapping
    public ResponseEntity<ApiResponse> addPatron(@RequestBody @Valid PatronDto patronDto) {
        patronService.addPatron(patronDto);
        return ResponseEntity.ok(ApiResponse.ok());
    }


    @PutMapping
    public ResponseEntity<ApiResponse> updatePatron(@RequestBody @Valid PatronDto patronDto) {
        patronService.updatePatron(patronDto);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePatron(@PathVariable("id") Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.ok(ApiResponse.ok());

    }
}
