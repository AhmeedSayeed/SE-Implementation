package Validation;

import Users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.FileReader;

/**
 * This class is responsible for validating a user's login credentials by checking the entered username and password
 * against the existing users stored in the system's user database (in a JSON file).
 *
 * It implements the {@link IValidation} interface, specifically the {@link #validate(User)} method.
 * The login validation process involves reading the users' data from a file and checking if the inputted username
 * and password match any existing users. If either the username or the password is incorrect, the login attempt will fail.
 *
 * If a match is found, the user is successfully logged in.
 */
public class LogIn implements IValidation {

    /**
     * Validates the login credentials of the given user by checking the username and password
     * against a list of users stored in the "users.json" file.
     *
     * @param user the user object containing the login credentials to validate
     * @return true if the username and password match an existing user, false otherwise
     */
    public Boolean validate(User user)
    {
        Gson gson = new Gson();
        Type userType = new TypeToken<ArrayList<User>>() {}.getType();
        File usersFile = new File("users.json");

        try (FileReader fileReader = new FileReader(usersFile)){
            ArrayList<User> users;

            // If the file is empty, initialize an empty list
            if (usersFile.length() == 0)
                users = new ArrayList<>();
            else
                users = gson.fromJson(fileReader, userType);

            // If the JSON is null, initialize an empty list
            if (users == null)
                users = new ArrayList<>();

            // Check if the entered username and password match any user in the list
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                    user.setBudgetManegement(u.getBudgetManegement());
                    System.out.println(user.getUsername() + ", logged in successfully");
                    return true;
                }
            }

            // If no match found, return false
            System.out.println("Invalid username or password");
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
