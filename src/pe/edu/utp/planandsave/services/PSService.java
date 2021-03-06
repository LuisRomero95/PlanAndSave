package pe.edu.utp.planandsave.services;

import pe.edu.utp.planandsave.actions.IncomeAction;
import pe.edu.utp.planandsave.actions.UserAction;
import pe.edu.utp.planandsave.models.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class PSService {
    Connection connection;
    PSDataStore dataStore;
    User user;

    public PSService(InitialContext ctx) {
        try {
            connection = ((DataSource) ctx.lookup("jdbc/MySQLPSDataSource")).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public PSService() {
        try {
            InitialContext ctx = new InitialContext();
            connection = ((DataSource) ctx.lookup("jdbc/MySQLPSDataSource")).getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private PSDataStore getDataStore(){
        if (dataStore == null){
            dataStore = new PSDataStore(getConnection());
        }
        return dataStore;
    }

    DecimalFormat DF = new DecimalFormat( "#,###,###,##0.00" );

    //Currencies
    public List<Currency> getCurrencies(){
        return getDataStore().findAllCurrencies();
    }

    public Currency getCurrenciesById(int id){
        return  getDataStore().findCurrencyById(id);
    }

    public Currency getCurrenciesById(String id){
        return getDataStore().findCurrencyById(Integer.parseInt(id));
    }


    //Subscriptions
    public Subscription getSubscriptionsById(int id){
        return getDataStore().findSubscriptionsById(id);
    }

    //Expenses

    public List<Expense> getExpenses(){
        return getDataStore().findAllExpenses();
    }

    public Expense getExpenseById(int id){
        return getDataStore().findExpenseById(id);
    }

    public boolean createExpense(Expense expense){
        return getDataStore().createExpense(expense);
    }

    public boolean deleteExpense(Expense expense){
        return  getDataStore().deleteExpense(expense);
    }

    public boolean updateExpense(Expense expense){
        return getDataStore().updateExpense(expense);
    }

    //ExpenseCategories
    public List<ExpensesCategory> getExpenseCategories() {
        return getDataStore().findAllExpenseCategories();
    }

    public ExpensesCategory getExpenseCategoriesById(int id){
        return getDataStore().findExpenseCategoriesById(id);
    }

    public ExpensesCategory getExpenseCategoriesById(String id){
        return getDataStore().findExpenseCategoriesById(Integer.parseInt(id));
    }

    public boolean createExpenseCategory(ExpensesCategory expensesCategory){
        return getDataStore().createExpenseCategory(expensesCategory);
    }

    //Incomes

    public List<Income> getIncomes() {
        return getDataStore().findAllIncomes();
    }

    public Income getIncomesById(int id){
        return getDataStore().findIncomesById(id);
    }

    public boolean createIncome(Income income){
        return getDataStore().createIncome(income);
    }

    public boolean deleteIncome(Income income){
        return getDataStore().deleteIncome(income);
    }

    public boolean updateIncome(Income income){
        return getDataStore().updateIncome(income);
    }

    //Goals

    public List<Goal> getGoals() {return getDataStore().findAllGoals();}

    public Goal getGoalById(int id){return getDataStore().findGoalsById(id); }

    public boolean createGoal(Goal goal){ return getDataStore().createGoal(goal);}

    public boolean deleteGoal(Goal goal){
        return getDataStore().deleteGoal(goal);
    }

    public boolean completeGoal(Goal goal){
        return  getDataStore().completeGoal(goal);
    }

    // Debts

    public List<Debt> getDebts(){ return getDataStore().findAllDebts(); }

    public Debt getDebtById(int id){ return getDataStore().findDebtsById(id); }

    public boolean createDebt(Debt debt){return getDataStore().createDebt(debt);}

    public boolean deleteDebt(Debt debt){return getDataStore().deleteDebt(debt);}

    //Users
    public List<User> getUsers(){
        return getDataStore().findAllUsers();
    }

    public boolean createUser(User user){
        return getDataStore().createUser(user);
    }

    public User getUsersByEmail(String email, String password){
        return getDataStore().findUsersByEmail(email, password);
    }

    public User getUsersById(int id){
        return getDataStore().findUsersById(id);
    }

    public User getUsersById(String id){
        return getDataStore().findUsersById(Integer.parseInt(id));
    }

    //Quotes
    public boolean createQuota(Quota quota){
        return getDataStore().createQuota(quota);
    }

    public Quota getQuotaById(int id){return getDataStore().findQuotaById(id);}

    //Periods
    public List<Period> getPeriods(){
        return getDataStore().findAllPeriods();
    }

    public Period getPeriodById(int id){
        return getDataStore().findPeriodById(id);
    }

    //Images
    public Image getImageById(int id){
        return getDataStore().findImageById(id);
    }



    /*
    public List<Region> getRegions() {
        return getDataStore().findAllRegions();
    }
     */
}
