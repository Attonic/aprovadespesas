package io.github.aprovadespesas.repositories;

import io.github.aprovadespesas.entity.Department;
import io.github.aprovadespesas.entity.Expense;
import io.github.aprovadespesas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByEmployee(User employee);

    List<Expense> findByEmployee_Department(Department employeeDepartment);


}
