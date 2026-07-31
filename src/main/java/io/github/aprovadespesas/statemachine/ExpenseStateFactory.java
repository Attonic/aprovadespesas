package io.github.aprovadespesas.statemachine;

import io.github.aprovadespesas.entity.enums.ExpenseStatus;

public class ExpenseStateFactory {

    public static ExpenseState from(ExpenseStatus status) {
        return switch (status){
            case PENDING -> new PendingState();
            case APPROVED -> new AprovedState();
            case REJECTED -> new RejectedState();
            case PAID -> new PaidState();
            case CANCELED -> new CancelledState();
        };
    }

}
