package Validation;

import Users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * This class is responsible for validating a user's sign-up process by checking if the username or email already exists
 * in the system's user database (stored in a JSON file).
 *
 * It implements the {@link IValidation} interface, specifically the {@link #validate(User)} method.
 * The validation process involves reading the users' data from a file and checking if the inputted username or email
 * matches any existing users. If either the username or email already exists, the user will not be allowed to sign up.
 *
 * If no conflicts are found, the user is considered successfully signed up.
 */
public class SignUp implements IValidation {

    /**
     * Validates the user input during the sign-up process.
     *
     * @param user The {@link User} object containing the user's details (username and email) to be validated.
     * @return {@code true} if the username and email are not already taken; {@code false} otherwise.
     *         Prints out error messages if the username or email already exists.
     */
    @Override
    public Boolean validate(User user) {
        Gson gson = new Gson();
        Type userType = new TypeToken<ArrayList<User>>() {}.getType();
        File usersFile = new File("users.json");

        try (FileReader fileReader = new FileReader(usersFile)) {
            ArrayList<User> users;
            // If file is empty, initialize an empty list
            if (usersFile.length() == 0)
                users = new ArrayList<>();
            else
                users = gson.fromJson(fileReader, userType);

            if (users == null)
                users = new ArrayList<>();

            // Check if the username or email already exists
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername())) {
                    System.out.println("Username already exists");
                    return false;
                }
                if (u.getEmail().equals(user.getEmail())) {
                    System.out.println("Email already exists");
                    return false;
                }
            }

            // If no conflicts, sign up is successful
            System.out.println(user.getUsername() + ", signed up successfully");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
