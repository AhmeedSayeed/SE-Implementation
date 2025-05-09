package Budget;

/**
 * Represents a budget category, which holds details about the category name,
 * the total allocated amount, and the spending limit for that category.
 */
public class Category {

    /** The name of the category. */
    private String categoryName;

    /** The total amount allocated for the category. */
    private Double totalAmount;

    /** The spending limit for the category. */
    private Double SpendingLimit;

    /**
     * Constructs a Category object with the specified category name, total amount, and spending limit.
     *
     * @param categoryName the name of the category
     * @param totalAmount the total amount allocated to the category
     * @param SpendingLimit the spending limit for the category
     */
    public Category(String categoryName, Double totalAmount, Double SpendingLimit)
    {
        this.categoryName = categoryName;
        this.totalAmount = totalAmount;
        this.SpendingLimit = SpendingLimit;
    }

    /**
     * Returns the name of the category.
     *
     * @return the name of the category
     */
    public String getCategoryName()
    {
        return this.categoryName;
    }

    /**
     * Returns the total amount allocated to the category.
     *
     * @return the total amount for the category
     */
    public Double getTotalAmount()
    {
        return this.totalAmount;
    }

    /**
     * Returns the spending limit for the category.
     *
     * @return the spending limit for the category
     */
    public Double getSpendingLimit()
    {
        return this.SpendingLimit;
    }

    /**
     * Sets the name of the category.
     *
     * @param categoryName the new name for the category
     */
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    /**
     * Sets the total amount allocated to the category.
     *
     * @param totalAmount the new total amount for the category
     */
    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    /**
     * Sets the spending limit for the category.
     *
     * @param spendingLimit the new spending limit for the category
     */
    public void setSpendingLimit(Double spendingLimit)
    {
        this.SpendingLimit = spendingLimit;
    }
}
