package io.github.aprovadespesas.dto.response;

import io.github.aprovadespesas.entity.Department;
import lombok.Builder;

@Builder
public record DepartmentResponse(
        Long id,
        String name,
        String description
) {
    public static DepartmentResponse fromEntity(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }
}
