package io.github.aprovadespesas.statemachine;

import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;
import io.github.aprovadespesas.exception.InvalidStateTransitionException;

public class CancelledState implements ExpenseState{

    @Override
    public void approve(Expense expense, User review) {
        throw  new InvalidStateTransitionException("Despesa cancelada não pode ser aprovada.");
    }

    @Override
    public void reject(Expense expense, User reviewer, String reason) {
        throw new InvalidStateTransitionException("Despesa cancelada não pode ser rejeitada.");
    }

    @Override
    public void pay(Expense expense, User review) {
        throw new InvalidStateTransitionException("Despesa cancelada não pode ser paga.");
    }

    @Override
    public void cancel(Expense expense, User review) {
        throw new InvalidStateTransitionException("Despesa cancelada não pode ser cancelada.");
    }
}
