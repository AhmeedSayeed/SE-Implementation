package Notifications;
import Budget.*;

public class ExceedingBudget implements INotification {
    public void sendNotification(BudgetManegement budget)
    {
        System.out.println("Warning: Spending limit exceeded for these categories.");
        for(Category c :  budget.getCategories())
        {
            if(c.getSpendingLimit() < c.getTotalAmount())
                System.out.println(c.getTotalAmount() - c.getSpendingLimit() + " has been over spending for " + c.getCategoryName() + " category.");
        }
        System.out.println();
    }
}
