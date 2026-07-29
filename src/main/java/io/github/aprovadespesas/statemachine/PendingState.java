package io.github.aprovadespesas.statemachine;

import com.sun.jdi.request.InvalidRequestStateException;
import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;
import io.github.aprovadespesas.entity.enums.ExpenseStatus;

import java.time.LocalDateTime;

public class PendingState implements ExpenseState{

    @Override
    public void approve(Expense expense, User review) {
            expense.setStatus(ExpenseStatus.APPROVED);
            expense.setReviewer(review);
            expense.setReviewedAt(LocalDateTime.now());
    }

    @Override
    public void reject(Expense expense, User reviewer, String reason) {
            expense.setStatus(ExpenseStatus.REJECTED);
            expense.setReviewer(reviewer);
            expense.setReviewedAt(LocalDateTime.now());
            expense.setRejectionReason(reason);
    }

    //TODO corrigir essa exception para uma personalizada = InvelidStateTransitionException
    @Override
    public void pay(Expense expense, User review) {
        throw new InvalidRequestStateException("Despensa como pendente não pode ser paga antes da aprovação.");
    }

    @Override
    public void cancel(Expense expense, User review) {
        expense.setStatus(ExpenseStatus.CANCELED);
        expense.setReviewer(review);
        expense.setReviewedAt(LocalDateTime.now());
    }
}
