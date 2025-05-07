package Income;
import java.util.ArrayList;

public class IncomeManagement {
    private ArrayList<IncomeSource> incomeSources = new ArrayList<IncomeSource>();
    private Double totalIncome = 0.0;

    public ArrayList<IncomeSource> getIncomeSources()
    {
        return incomeSources;
    }
    public Double getTotalIncome()
    {
        return totalIncome;
    }

    public void addIncomeSource(IncomeSource incomeSource)
    {
        incomeSources.add(incomeSource);
        totalIncome += incomeSource.getAmount();
    }
    public void removeIncomeSource(IncomeSource incomeSource)
    {
        incomeSources.remove(incomeSource);
        totalIncome -= incomeSource.getAmount();
    }
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
