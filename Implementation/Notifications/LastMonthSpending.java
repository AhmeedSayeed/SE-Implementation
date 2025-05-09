package Notifications;

import Budget.*;

/**
 * A concrete implementation of the INotification interface.
 * This class sends a notification displaying the total amount spent in each category for the last month.
 */
public class LastMonthSpending implements INotification {

    /**
     * Sends a notification displaying the total amount spent for each category in the budget.
     *
     * @param budget the budget management system containing the categories and their spending details
     */
    public void sendNotification(BudgetManegement budget)
    {
        System.out.println("Last Month Spending:");

        // Loop through all categories in the budget and display their total spending
        for(Category c :  budget.getCategories())
        {
            System.out.printf("%.2f$ has been spent for %s category.",c.getTotalAmount(),c.getCategoryName());
        }
        if(budget.getCategories().isEmpty())
            System.out.println("There are no categories and no spending for this budget.");

        System.out.println();
    }
}
