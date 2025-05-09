package Transactions;

/**
 * This class represents a financial transaction with details about the transaction's name, category, and amount.
 * It is used to store and manage information related to individual transactions within a budgeting or financial management system.
 *
 * <p>A {@link Transaction} object encapsulates the following details:
 * - The name of the transaction (e.g., "Grocery shopping")
 * - The category of the transaction (e.g., "Food")
 * - The amount of money involved in the transaction</p>
 */
public class Transaction {
    private String name;
    private String categoryName;
    private Double amount;

    /**
     * Constructor to initialize a new transaction with the given name, category, and amount.
     *
     * @param name the name of the transaction (e.g., "Grocery shopping")
     * @param categoryName the category of the transaction (e.g., "Food")
     * @param amount the amount of money involved in the transaction
     */
    public Transaction(String name, String categoryName, Double amount)
    {
        this.name = name;
        this.categoryName = categoryName;
        this.amount = amount;
    }

    /**
     * Sets the name of the transaction.
     *
     * @param name the name of the transaction
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the category of the transaction.
     *
     * @param categoryName the category of the transaction
     */
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    /**
     * Sets the amount of the transaction.
     *
     * @param amount the amount of money involved in the transaction
     */
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    /**
     * Gets the name of the transaction.
     *
     * @return the name of the transaction
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the category of the transaction.
     *
     * @return the category of the transaction
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * Gets the amount of the transaction.
     *
     * @return the amount of the transaction
     */
    public Double getAmount()
    {
        return amount;
    }
}
