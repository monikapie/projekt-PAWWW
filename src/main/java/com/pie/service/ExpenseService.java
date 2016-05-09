package com.pie.service;

import com.pie.dao.ExpenseDao;
import com.pie.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pie on 5/3/16.
 */
@Service("expenseService")
@Transactional
public class ExpenseService {
    @Autowired
    private ExpenseDao dao;

    public List<Expense> findExpenses(int id){
        return dao.findExpenses(id);
    }

    public void addExpense(Expense expense, int id){
        dao.addExpense(expense, id);
    }

    public void deleteExpense(int id){
        dao.deleteExpense(id);
    }
}
