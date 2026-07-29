package io.github.aprovadespesas.statemachine;

import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;

public interface ExpenseState {

    void approve(Expense expense, User review);

    void reject(Expense expense, User reviewer, String reason);

    void pay(Expense expense, User review);

    void cancel(Expense expense, User review);



}
