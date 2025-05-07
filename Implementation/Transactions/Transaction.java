package Transactions;

public class Transaction {
    private String name;
    private String categoryName;
    private Double amount;

    public Transaction(String name, String categoryName, Double amount)
    {
        this.name = name;
        this.categoryName = categoryName;
        this.amount = amount;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getCategoryName()
    {
        return categoryName;
    }
    public Double getAmount()
    {
        return amount;
    }
    public String getName()
    {
        return name;
    }
}
