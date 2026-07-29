package io.github.aprovadespesas.statemachine;

import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;

import java.time.LocalDateTime;

public class AprovedState implements ExpenseState{

    //TODO corrigir essa exception para uma personalizada = InvelidStateTransitionException
    @Override
    public void approve(Expense expense, User review) {
        throw new RuntimeException("Despesa já está aprovada");
    }

    @Override
    public void reject(Expense expense, User reviewer, String reason) {
        throw new RuntimeException("Despesa aprovada não pode ser rejeitada.");
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
