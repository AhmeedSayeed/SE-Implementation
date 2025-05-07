package Income;

public class IncomeSource {
    private String name;
    private Double amount;

    public IncomeSource(String name, Double amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }
    public Double getAmount()
    {
        return amount;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
}
