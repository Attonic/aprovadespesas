package io.github.aprovadespesas.dto.response;

import io.github.aprovadespesas.entity.enums.ExpenseStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseResponse(
        Long id,
        String description,
        BigDecimal amount,
        String category,
        ExpenseStatus status,
        String employeeName,
        String reviewerName,
        String rejectionReason,
        LocalDateTime createdAt,
        LocalDateTime reviewedAt,
        LocalDateTime paidAt
) {
}
