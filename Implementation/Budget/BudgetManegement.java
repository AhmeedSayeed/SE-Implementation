package Budget;
import Notifications.INotification;
import Transactions.*;
import Income.*;
import java.util.*;

public class BudgetManegement {
    private TransactionsManagent transactionsManagent = new TransactionsManagent();
    private IncomeManagement incomeManagement  = new IncomeManagement();
    private ArrayList<Category> categories = new ArrayList<Category>();
    private INotification notification;

    public ArrayList<Category> getCategories()
    {
        return categories;
    }
    public ArrayList<Transaction> getTransactions()
    {
        return transactionsManagent.getTransactions();
    }
    public ArrayList<IncomeSource> getIncomeSources()
    {
        return incomeManagement.getIncomeSources();
    }
    public Double getTotalIncome()
    {
        return incomeManagement.getTotalIncome();
    }
    public Double getTotalExpense()
    {
        return transactionsManagent.getTotalExpense();
    }

    public void addTransaction(Transaction transaction)
    {
        transactionsManagent.addTransaction(transaction);
    }
    public void removeTransaction(Transaction transaction)
    {
        transactionsManagent.removeTransaction(transaction);
    }
    public void editTransaction(Transaction transaction, Transaction editedTransaction)
    {
        transactionsManagent.editTransaction(transaction, editedTransaction);
    }

    public void addIncomeSource(IncomeSource incomeSource)
    {
        incomeManagement.addIncomeSource(incomeSource);
    }
    public void removeIncomeSource(IncomeSource incomeSource)
    {
        incomeManagement.removeIncomeSource(incomeSource);
    }
    public void editIncomeSource(IncomeSource incomeSource, IncomeSource editedIncomeSource)
    {
        incomeManagement.editIncomeSource(incomeSource, editedIncomeSource);
    }

    public void addCategory(Category category)
    {
        categories.add(category);
    }
    public void removeCategory(Category category)
    {
        categories.remove(category);
    }
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

    public void sendNotification()
    {
        notification.sendNotification(this);
    }
}
