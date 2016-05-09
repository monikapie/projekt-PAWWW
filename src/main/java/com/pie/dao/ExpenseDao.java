package com.pie.dao;

import com.pie.model.Expense;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("expenseDao")
public class ExpenseDao extends AbstractDao<Integer, Expense> {

    @SuppressWarnings("unchecked")
    public List<Expense> findExpenses(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Expense>) criteria.list();
    }

    public void addExpense(Expense expense, int id){
        String q = "INSERT INTO Expense(name, cost, member_id, user_id) " +
                "VALUES(:name, :cost, :member_id, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", expense.getName())
                .setParameter("cost", expense.getCost())
                .setParameter("member_id", expense.getMember_id())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteExpense(int id){
        String q = "DELETE FROM Expense WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
