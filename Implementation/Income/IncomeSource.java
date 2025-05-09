package Income;

/**
 * Represents an income source, such as a salary or business income.
 * Contains the name of the income source and the amount associated with it.
 */
public class IncomeSource {

    /** The name of the income source. */
    private String name;

    /** The amount of money associated with the income source. */
    private Double amount;

    /**
     * Constructs an IncomeSource object with the specified name and amount.
     *
     * @param name the name of the income source
     * @param amount the amount of money associated with the income source
     */
    public IncomeSource(String name, Double amount)
    {
        this.name = name;
        this.amount = amount;
    }

    /**
     * Gets the name of the income source.
     *
     * @return the name of the income source
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the amount of money associated with the income source.
     *
     * @return the amount of money for the income source
     */
    public Double getAmount()
    {
        return amount;
    }

    /**
     * Sets the name of the income source.
     *
     * @param name the new name for the income source
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Sets the amount of money associated with the income source.
     *
     * @param amount the new amount for the income source
     */
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
}
