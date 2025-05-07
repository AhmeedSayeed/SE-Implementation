package Budget;

public class Category {
    private String categoryName;
    private String categoryId;
    private Double totalAmount;
    private Double SpendingLimit;

    public Category(String categoryName, String categoryId, Double totalAmount, Double SpendingLimit)
    {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.totalAmount = totalAmount;
        this.SpendingLimit = SpendingLimit;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }
    public String getCategoryId()
    {
        return this.categoryId;
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
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }
    public void  setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    public void setSpendingLimit(Double spendingLimit) {
        SpendingLimit = spendingLimit;
    }
}
