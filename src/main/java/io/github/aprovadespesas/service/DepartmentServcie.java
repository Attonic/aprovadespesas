package io.github.aprovadespesas.service;

import io.github.aprovadespesas.dto.request.DepartmentRequest;
import io.github.aprovadespesas.dto.response.DepartmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentServcie {

    DepartmentResponse findById(Long id);

    DepartmentResponse createDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse updateDeparment(Long id, DepartmentRequest departmentRequest);

    DepartmentResponse findByName(String name);

    Page<DepartmentResponse> findAll(Pageable pageable);


}
