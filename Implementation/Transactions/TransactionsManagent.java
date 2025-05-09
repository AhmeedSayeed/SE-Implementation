package Transactions;
import java.util.ArrayList;

/**
 * This class is responsible for managing a collection of {@link Transaction} objects.
 * It allows adding, removing, and editing transactions as well as keeping track of the total expenses.
 *
 * <p>The {@link TransactionsManagent} class encapsulates the following features:
 * - Storing a list of transactions
 * - Calculating the total expense across all transactions
 * - Providing methods to add, remove, and edit individual transactions in the list.</p>
 */
public class TransactionsManagent {
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private Double totalExpense = 0.0;

    /**
     * Gets the list of all transactions managed by this class.
     *
     * @return the list of transactions
     */
    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }

    /**
     * Gets the total expense calculated from all transactions.
     *
     * @return the total expense
     */
    public Double getTotalExpense()
    {
        return totalExpense;
    }

    /**
     * Adds a new transaction to the transaction list.
     *
     * @param transaction the transaction to add
     */
    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
        totalExpense += transaction.getAmount(); // Update total expense when a new transaction is added
    }

    /**
     * Removes a transaction from the transaction list.
     *
     * @param transaction the transaction to remove
     */
    public void removeTransaction(Transaction transaction)
    {
        if (transactions.remove(transaction)) {
            totalExpense -= transaction.getAmount(); // Update total expense when a transaction is removed
        }
    }

    /**
     * Edits an existing transaction by replacing its details with the edited transaction's details.
     *
     * @param transaction the original transaction to be edited
     * @param editedTransaction the new transaction with updated details
     */
    public void editTransaction(Transaction transaction, Transaction editedTransaction)
    {
        for(Transaction t : transactions)
        {
            if (t.equals(transaction))
            {
                totalExpense -= t.getAmount(); // Subtract old transaction's amount from total expense
                t.setName(editedTransaction.getName());
                t.setAmount(editedTransaction.getAmount());
                t.setCategoryName(editedTransaction.getCategoryName());
                totalExpense += editedTransaction.getAmount(); // Add new transaction's amount to total expense
            }
        }
    }
}
