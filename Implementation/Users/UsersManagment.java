package Users;

import java.util.ArrayList;

/**
 * This class is responsible for managing a collection of {@link User} objects.
 * It allows adding, removing, and editing users within the system.
 *
 * <p>The {@link UsersManagment} class provides methods to handle user data, including:
 * adding a new user, removing an existing user, and editing the details of an existing user.
 * This class serves as the central point for managing the users within the system.</p>
 */
public class UsersManagment {
    private ArrayList<User> users = new ArrayList<User>();

    /**
     * Gets the list of all users in the system.
     *
     * @return the list of users
     */
    public ArrayList<User> getUsers()
    {
        return users;
    }

    /**
     * Sets the list of users in the system.
     *
     * @param users the new list of users to set
     */
    public void setUsers(ArrayList<User> users)
    {
        this.users = users;
    }

    /**
     * Adds a new user to the system.
     *
     * @param user the {@link User} object to add
     */
    public void addUser(User user)
    {
        users.add(user);
    }

    /**
     * Removes a user from the system.
     *
     * @param user the {@link User} object to remove
     */
    public void removeUser(User user)
    {
        users.remove(user);
    }

    /**
     * Edits an existing user's information in the system.
     * The user's username, email, and password will be updated based on the details of the provided edited user.
     *
     * @param user the {@link User} object to edit
     * @param editedUser the {@link User} object containing the new details
     */
    public void editUser(User user, User editedUser)
    {
        for(User u : users)
        {
            if(u.equals(user))
            {
                u.setUsername(editedUser.getUsername());
                u.setEmail(editedUser.getEmail());
                u.setPassword(editedUser.getPassword());
            }
        }
    }
}
