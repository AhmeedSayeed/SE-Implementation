package Transactions;
import java.util.ArrayList;

public class TransactionsManagent {
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private Double totalExpense = 0.0;

    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }
    public Double getTotalExpense()
    {
        return totalExpense;
    }

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }
    public void removeTransaction(Transaction transaction)
    {
        transactions.remove(transaction);
    }
    public void editTransaction(Transaction transaction, Transaction editedTransaction)
    {
        for(Transaction t : transactions)
        {
            if (t.equals(transaction))
            {
                t.setName(editedTransaction.getName());
                t.setAmount(editedTransaction.getAmount());
                t.setCategoryName(editedTransaction.getCategoryName());
            }
        }
    }
}
