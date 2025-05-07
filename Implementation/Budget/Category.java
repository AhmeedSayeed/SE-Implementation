package Budget;

public class Category {
    private String categoryName;
    private Double totalAmount;
    private Double SpendingLimit;

    public Category(String categoryName, Double totalAmount, Double SpendingLimit)
    {
        this.categoryName = categoryName;
        this.totalAmount = totalAmount;
        this.SpendingLimit = SpendingLimit;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }
    public Double getTotalAmount()
    {
        return this.totalAmount;
    }
    public Double getSpendingLimit()
    {
        return this.SpendingLimit;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    public void setSpendingLimit(Double spendingLimit)
    {
        SpendingLimit = spendingLimit;
    }
}
