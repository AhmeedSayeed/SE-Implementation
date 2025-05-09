package Budget;

import Notifications.INotification;
import Transactions.*;
import Income.*;
import java.util.*;

/**
 * Manages the budget system, including transactions, income sources, categories, and notifications.
 * Provides methods to add, remove, and edit categories, transactions, and income sources.
 */
public class BudgetManegement {

    private TransactionsManagent transactionsManagent = new TransactionsManagent();
    private IncomeManagement incomeManagement  = new IncomeManagement();
    private ArrayList<Category> categories = new ArrayList<Category>();
    private transient INotification notification;

    /**
     * Returns the list of categories in the budget.
     *
     * @return the list of categories
     */
    public ArrayList<Category> getCategories()
    {
        return categories;
    }

    /**
     * Returns the list of transactions in the budget.
     *
     * @return the list of transactions
     */
    public ArrayList<Transaction> getTransactions()
    {
        return transactionsManagent.getTransactions();
    }

    /**
     * Returns the list of income sources in the budget.
     *
     * @return the list of income sources
     */
    public ArrayList<IncomeSource> getIncomeSources()
    {
        return incomeManagement.getIncomeSources();
    }

    /**
     * Returns the total income from all income sources.
     *
     * @return the total income
     */
    public Double getTotalIncome()
    {
        return incomeManagement.getTotalIncome();
    }

    /**
     * Returns the total expense from all transactions.
     *
     * @return the total expense
     */
    public Double getTotalExpense()
    {
        return transactionsManagent.getTotalExpense();
    }

    /**
     * Returns the total spending limit from all categories.
     *
     * @return the total spending limit
     */
    public Double getTotalSpendingLimit()
    {
        Double total = 0.0;
        for (Category category : categories)
            total += category.getSpendingLimit();
        return total;
    }

    /**
     * Adds a new transaction to the budget.
     *
     * @param transaction the transaction to add
     */
    public void addTransaction(Transaction transaction)
    {
        transactionsManagent.addTransaction(transaction);
    }

    /**
     * Removes a transaction from the budget.
     *
     * @param transaction the transaction to remove
     */
    public void removeTransaction(Transaction transaction)
    {
        transactionsManagent.removeTransaction(transaction);
    }

    /**
     * Edits an existing transaction in the budget.
     *
     * @param transaction the transaction to edit
     * @param editedTransaction the new details for the transaction
     */
    public void editTransaction(Transaction transaction, Transaction editedTransaction)
    {
        transactionsManagent.editTransaction(transaction, editedTransaction);
    }

    /**
     * Adds a new income source to the budget.
     *
     * @param incomeSource the income source to add
     */
    public void addIncomeSource(IncomeSource incomeSource)
    {
        incomeManagement.addIncomeSource(incomeSource);
    }

    /**
     * Removes an income source from the budget.
     *
     * @param incomeSource the income source to remove
     */
    public void removeIncomeSource(IncomeSource incomeSource)
    {
        incomeManagement.removeIncomeSource(incomeSource);
    }

    /**
     * Edits an existing income source in the budget.
     *
     * @param incomeSource the income source to edit
     * @param editedIncomeSource the new details for the income source
     */
    public void editIncomeSource(IncomeSource incomeSource, IncomeSource editedIncomeSource)
    {
        incomeManagement.editIncomeSource(incomeSource, editedIncomeSource);
    }

    /**
     * Adds a new category to the budget.
     *
     * @param category the category to add
     */
    public void addCategory(Category category)
    {
        categories.add(category);
    }

    /**
     * Removes a category from the budget.
     *
     * @param category the category to remove
     */
    public void removeCategory(Category category)
    {
        categories.remove(category);
    }

    /**
     * Edits an existing category in the budget.
     * Updates the name, total amount, and spending limit of the category.
     *
     * @param category the category to edit
     * @param editedCategory the new details for the category
     */
    public void editCategory(Category category, Category editedCategory)
    {
        for(Category c : categories)
        {
            if(c.equals(category))
            {
                c.setCategoryName(editedCategory.getCategoryName());
                c.setTotalAmount(editedCategory.getTotalAmount());
                c.setSpendingLimit(editedCategory.getSpendingLimit());
            }
        }
    }

    /**
     * Sets the notification service to use for sending notifications.
     *
     * @param notification the notification service
     */
    public void setNotification(INotification notification)
    {
        this.notification = notification;
    }

    /**
     * Sends a notification using the configured notification service.
     */
    public void sendNotification()
    {
        notification.sendNotification(this);
    }
}
