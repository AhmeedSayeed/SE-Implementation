package Users;
import java.util.ArrayList;

public class UsersManagment {
    private ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers()
    {
        return users;
    }

    public void setUsers(ArrayList<User> users)
    {
        this.users = users;
    }
    public void addUser(User user)
    {
        users.add(user);
    }
    public void removeUser(User user)
    {
        users.remove(user);
    }
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
