package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class ExpensesEntity extends BaseEntity {

    public ExpensesEntity(Connection connection) {
        super(connection, "expenses");
    }

    public ExpensesEntity() {
        super();
    }

    List<Expense> findAll(UsersEntity usersEntity, UsersCategoryEntity usersCategoryEntity, ExpensesCategoryEntity expensesCategoryEntity,
                          CurrenciesEntity currenciesEntity){
        return findByCriteria("", usersEntity, usersCategoryEntity, expensesCategoryEntity, currenciesEntity);
    }

    public Expense findById(int id, UsersEntity usersEntity, UsersCategoryEntity usersCategoryEntity,
                            ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity){
        String criteria = " id = " + id;
        return findByCriteria(criteria, usersEntity, usersCategoryEntity, expensesCategoryEntity, currenciesEntity).get(0);
    }

    public List<Expense> findByCriteria(String criteria, UsersEntity usersEntity, UsersCategoryEntity usersCategoryEntity,
                                        ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Expense> expenses = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                expenses.add(Expense.build(resultSet, usersEntity, usersCategoryEntity,
                        expensesCategoryEntity, currenciesEntity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
