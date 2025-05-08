package Users;
import Validation.*;
import Budget.BudgetManegement;

public class User {
    private String username;
    private String email;
    private String password;
    private BudgetManegement budgetManegement = new BudgetManegement();

    public User(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername()
    {
        return this.username;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPassword()
    {
        return this.password;
    }
    public BudgetManegement getBudgetManegement()
    {
        return this.budgetManegement;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setBudgetManegement(BudgetManegement budgetManegement)
    {
        this.budgetManegement = budgetManegement;
    }
}
