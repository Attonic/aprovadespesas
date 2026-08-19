package io.github.aprovadespesas.controller;

import io.github.aprovadespesas.dto.request.DepartmentRequest;
import io.github.aprovadespesas.dto.response.DepartmentResponse;
import io.github.aprovadespesas.service.DepartmentServcie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3000)
public class DepartmentController {

    private final DepartmentServcie departmentServcie;

    @GetMapping
    public ResponseEntity<Page<DepartmentResponse>> findAll(
            Pageable pageable) {
        return ResponseEntity.ok(departmentServcie.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findById(
            @PathVariable Long id ){
        return ResponseEntity.ok(departmentServcie.findById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(
            @Valid @RequestBody DepartmentRequest request
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departmentServcie.createDepartment(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentRequest request
            ){
        return ResponseEntity.ok(departmentServcie.updateDeparment(id, request));
    }




}
