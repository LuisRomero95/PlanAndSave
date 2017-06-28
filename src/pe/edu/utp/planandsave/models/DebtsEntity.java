package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class DebtsEntity extends BaseEntity{

    public DebtsEntity(Connection connection) {
        super(connection, "debts");
    }

    public DebtsEntity() {
        super();
    }

    public List<Debt> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                              ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity){
        return findByCriteria("", usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity);
    }

    public Debt findById(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                         ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity){
        String criteria = " id = " + id;
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity).get(0);
    }

    public List<Debt> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                     ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Debt> debts = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                debts.add(Debt.build(resultSet, usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity));
            }
            return debts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
