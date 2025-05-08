package Validation;
import Users.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.FileReader;

public class LogIn implements IValidation {
    public Boolean validate(User user)
    {
        Gson gson = new Gson();
        Type userType = new TypeToken<ArrayList<User>>() {}.getType();
        try (FileReader fileReader = new FileReader("Implementation/users.json")){
            ArrayList<User> users = gson.fromJson(fileReader, userType);
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                    System.out.println(user.getUsername() + ", logged in successfully");
                    return true;
                }
            }
            System.out.println("Invalid username or password");
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
