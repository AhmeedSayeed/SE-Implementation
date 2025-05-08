package Validation;
import Users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SignUp implements IValidation {
    public Boolean validate(User user)
    {
        Gson gson = new Gson();
        Type userType = new TypeToken<ArrayList<User>>() {}.getType();
        File usersFile = new File("users.json");
        try (FileReader fileReader = new FileReader(usersFile)){
            ArrayList<User> users;
            if (usersFile.length() == 0)
                users = new ArrayList<>();
            users = gson.fromJson(fileReader, userType);
            if (users == null)
                users = new ArrayList<>();
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
            System.out.println(user.getUsername() + ", signed up successfully");
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
