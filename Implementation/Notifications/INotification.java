package Notifications;

import Budget.*;

/**
 * Represents a notification service that can send notifications related to the budget.
 * The implementation of this interface should define how notifications are sent.
 */
public interface INotification {

    /**
     * Sends a notification related to the specified budget management system.
     *
     * @param budget the budget management system to send a notification for
     */
    public void sendNotification(BudgetManegement budget);
}
