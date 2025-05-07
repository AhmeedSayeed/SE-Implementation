package Notifications;
import Budget.*;

public class LastMonthSpending implements INotification {
    public void sendNotification(BudgetManegement budget)
    {
        System.out.println("Last Month Spending:");
        for(Category c :  budget.getCategories())
        {
            System.out.println(c.getTotalAmount() + " has been spending for " + c.getCategoryName() + " category.");
        }
        System.out.println();
    }
}
