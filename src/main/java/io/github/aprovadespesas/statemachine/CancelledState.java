package io.github.aprovadespesas.statemachine;

import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;

public class CancelledState implements ExpenseState{

    @Override
    public void approve(Expense expense, User review) {
        //TODO implementar InvalidStateTransitionException
    }

    @Override
    public void reject(Expense expense, User reviewer, String reason) {
        //TODO implementar InvalidStateTransitionException
    }

    @Override
    public void pay(Expense expense, User review) {
        //TODO implementar InvalidStateTransitionException
    }

    @Override
    public void cancel(Expense expense, User review) {
        //TODO implementar InvalidStateTransitionException
    }
}
