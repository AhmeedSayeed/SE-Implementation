package Notifications;

import Budget.*;

/**
 * A concrete implementation of the INotification interface.
 * This class sends a warning notification if the spending limit is exceeded in any category.
 */
public class ExceedingBudget implements INotification {

    /**
     * Sends a notification if the spending limit is exceeded in any category of the budget.
     * It will print the amount exceeding the limit for each category.
     *
     * @param budget the budget management system containing the categories and their spending details
     */
    public void sendNotification(BudgetManegement budget)
    {
        System.out.println("Warning: Spending limit exceeded for these categories.");

        // Loop through all categories in the budget and check if the spending limit is exceeded
        for(Category c :  budget.getCategories())
        {
            if(c.getSpendingLimit() < c.getTotalAmount())
                System.out.printf("%.2f$ has been over spending for %s category.%n",
                        c.getTotalAmount() - c.getSpendingLimit(), c.getCategoryName());
        }

        System.out.println();
    }
}
