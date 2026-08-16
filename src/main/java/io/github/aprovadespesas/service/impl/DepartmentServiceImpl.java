package io.github.aprovadespesas.service.impl;

import io.github.aprovadespesas.dto.request.DepartmentRequest;
import io.github.aprovadespesas.dto.response.DepartmentResponse;
import io.github.aprovadespesas.entity.Department;
import io.github.aprovadespesas.exception.ConflictException;
import io.github.aprovadespesas.exception.NotFoundException;
import io.github.aprovadespesas.repositories.DepartmentRepository;
import io.github.aprovadespesas.service.DepartmentServcie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentServcie {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse findById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departamento não encontrado."));
        return DepartmentResponse.fromEntity(department);
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .name(departmentRequest.name())
                .description(departmentRequest.description())
                .build();

        departmentRepository.save(department);
        return DepartmentResponse.fromEntity(department);
    }

    @Override
    public DepartmentResponse updateDeparment(DepartmentRequest departmentRequest) {

        if (departmentRepository.existsByName(departmentRequest.name())){
            throw new ConflictException("Já existe departamento com esse nome.");
        }

        Department department = departmentRepository.findById(departmentRequest.id())
                .orElseThrow(() -> new NotFoundException("Departamento não encontrado."));

        department.setName(departmentRequest.name());
        department.setDescription(departmentRequest.description());

        departmentRepository.save(department);
        return DepartmentResponse.fromEntity(department);

    }

    @Override
    public DepartmentResponse findByName(String name) {
        Department department = departmentRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Departamento não encontrado para esse nome."));
        return DepartmentResponse.fromEntity(department);

    }

    @Override
    public Page<DepartmentResponse> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable)
                .map(DepartmentResponse::fromEntity);
    }
}
