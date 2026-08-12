package io.github.aprovadespesas.statemachine;

import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;
import io.github.aprovadespesas.exception.InvalidStateTransitionException;

public class PaidState implements ExpenseState{
    @Override
    public void approve(Expense expense, User review) {
        throw new InvalidStateTransitionException("Despesa já se encontra paga.");
    }

    @Override
    public void reject(Expense expense, User reviewer, String reason) {
        throw new InvalidStateTransitionException("Despesa já se encontra paga.");
    }

    @Override
    public void pay(Expense expense, User review) {
        throw new InvalidStateTransitionException("Despesa já se encontra paga.");
    }

    @Override
    public void cancel(Expense expense, User review) {
        throw new InvalidStateTransitionException("Despesa já se encontra paga.");
    }
}
