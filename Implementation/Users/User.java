package Users;

import Budget.BudgetManegement;
import Validation.*;

/**
 * Represents a user in the system with their personal information, authentication details, and budget management.
 * A user is associated with a unique username, email, and password, as well as a budget management system to track their finances.
 *
 * <p>This class allows for setting and getting the user's details, performing validation using the {@link IValidation} interface,
 * and accessing the user's {@link BudgetManegement} for budgeting purposes.</p>
 */
public class User {
    private String username;
    private String email;
    private String password;
    private transient IValidation validation;
    private BudgetManegement budgetmanegement = new BudgetManegement();

    /**
     * Constructs a new User object with the specified username, email, and password.
     *
     * @param username the username of the user
     * @param email the email of the user
     * @param password the password of the user
     */
    public User(String username, String email, String password, BudgetManegement budgetmanegement)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.budgetmanegement = budgetmanegement;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * Gets the user's budget management system.
     *
     * @return the {@link BudgetManegement} object associated with the user
     */
    public BudgetManegement getBudgetManegement()
    {
        return this.budgetmanegement;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Sets the user's budget management system.
     *
     * @return the {@link BudgetManegement} object associated with the user
     */
    public void setBudgetManegement(BudgetManegement budgetmanegement)
    {
        this.budgetmanegement =  budgetmanegement;
    }

    /**
     * Sets the validation strategy for the user.
     *
     * @param validation an {@link IValidation} implementation used to validate user data (e.g., sign-up, login)
     */
    public void setValidation(IValidation validation)
    {
        this.validation = validation;
    }

    /**
     * Validates the user using the set validation strategy.
     *
     * @return true if the user passes the validation process, false otherwise
     */
    public Boolean validate()
    {
        return validation.validate(this);
    }
}
