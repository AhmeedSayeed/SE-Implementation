package Budget;
import Notifications.INotification;

import java.util.*;

public class BudgetManegement {
    private ArrayList<Category> categories;
    private INotification notification;
    private Double totalIncome;

    public  BudgetManegement()
    {

    }

    public ArrayList<Category> getCategories()
    {
        return categories;
    }
    public Double getTotalIncome()
    {
        return totalIncome;
    }

    public void setCategories(ArrayList<Category> categories)
    {
        this.categories = categories;
    }
    public void setTotalIncome(Double totalIncome)
    {
        this.totalIncome = totalIncome;
    }
    public void addCategory(Category category)
    {
        categories.add(category);
    }
    public void deleteCategory(Category category)
    {
        categories.remove(category);
    }
    public void editCategory(Category category, Category editedCategory)
    {
        for(Category c : categories)
        {
            if(c.equals(category))
                c =  editedCategory;
        }
    }

    public void sendNotification()
    {
        notification.sendNotification(this);
    }
}
