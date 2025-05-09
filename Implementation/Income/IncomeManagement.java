package Income;

import java.util.ArrayList;

/**
 * Manages the list of income sources and the calculation of total income.
 * Provides methods to add, remove, and edit income sources.
 */
public class IncomeManagement {

    /** The list of income sources. */
    private ArrayList<IncomeSource> incomeSources = new ArrayList<IncomeSource>();

    /** The total income from all income sources. */
    private Double totalIncome = 0.0;

    /**
     * Returns the list of income sources.
     *
     * @return the list of income sources
     */
    public ArrayList<IncomeSource> getIncomeSources()
    {
        return incomeSources;
    }

    /**
     * Returns the total income from all income sources.
     *
     * @return the total income
     */
    public Double getTotalIncome()
    {
        return totalIncome;
    }

    /**
     * Adds a new income source to the income management system and updates the total income.
     *
     * @param incomeSource the income source to add
     */
    public void addIncomeSource(IncomeSource incomeSource)
    {
        incomeSources.add(incomeSource);
        totalIncome += incomeSource.getAmount();
    }

    /**
     * Removes an income source from the income management system and updates the total income.
     *
     * @param incomeSource the income source to remove
     */
    public void removeIncomeSource(IncomeSource incomeSource)
    {
        incomeSources.remove(incomeSource);
        totalIncome -= incomeSource.getAmount();
    }

    /**
     * Edits an existing income source in the income management system, updating its amount and name,
     * and recalculating the total income.
     *
     * @param incomeSource the income source to edit
     * @param editedIncomeSource the new details for the income source
     */
    public void editIncomeSource(IncomeSource incomeSource, IncomeSource editedIncomeSource)
    {
        for(IncomeSource i : incomeSources)
        {
            if(i.equals(incomeSource))
            {
                totalIncome -= incomeSource.getAmount();
                i.setAmount(editedIncomeSource.getAmount());
                totalIncome += editedIncomeSource.getAmount();
                i.setName(editedIncomeSource.getName());
            }
        }
    }
}
