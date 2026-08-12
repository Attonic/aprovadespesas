package io.github.aprovadespesas.statemachine;

import com.sun.jdi.request.InvalidRequestStateException;
import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;
import io.github.aprovadespesas.exception.InvalidStateTransitionException;

import java.time.LocalDateTime;

public class AprovedState implements ExpenseState{


    @Override
    public void approve(Expense expense, User review) {
        throw new InvalidStateTransitionException("Despesa já está aprovada");
    }

    @Override
    public void reject(Expense expense, User reviewer, String reason) {
        throw new InvalidStateTransitionException("Despesa aprovada não pode ser rejeitada.");
    }

    @Override
    public void pay(Expense expense, User review) {
        expense.setReviewer(review);
        expense.setPaidAt(LocalDateTime.now());
    }

    @Override
    public void cancel(Expense expense, User review) {

    }
}
