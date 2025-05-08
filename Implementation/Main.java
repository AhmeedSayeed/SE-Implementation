import Users.User;
import Users.UsersManagment;
import Validation.IValidation;
import Validation.SignUp;
import Validation.LogIn;
import com.google.gson.*; // Gson Library to deal with JSON Files
import java.io.*; // For File Reader/Writer
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SignUp signUp = new SignUp();
    static LogIn logIn = new LogIn();
    static UsersManagment usersManagment = new UsersManagment();
    static String filePath = "Implementation/users.json";
    static Gson gson = new Gson();
    static Type userType = new TypeToken<ArrayList<User>>() {}.getType();
    static User curUser = new User("", "", "");


    public static boolean emailValidation(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static void readUserInfoSignUp(User user) {
        System.out.println("Please enter your username: ");
        String username = scanner.next();
        user.setUsername(username);

        System.out.println("Please enter your email: ");
        String email = scanner.next();
        if (emailValidation(email)) {
            user.setEmail(email);
        } else {
            System.out.println("Invalid email format");
            user.setUsername("");
            return;
        }

        System.out.println("Please enter your password: ");
        String password = scanner.next();
        user.setPassword(password);
    }

    public static void readUserInfoLogIn(User user) {
        System.out.println("Please enter your username: ");
        String username = scanner.next();
        user.setUsername(username);

        System.out.println("Please enter your password: ");
        String password = scanner.next();
        user.setPassword(password);
    }

    public static void addToJsonFile(User user) {
        try (FileReader fileReader = new FileReader(filePath)) {
            ArrayList<User> users = gson.fromJson(fileReader, userType);
            users.add(user);
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                gson.toJson(users, fileWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMenu() {
        System.out.println("Welcome to our personal budgeting System");
        System.out.println("----------------------------------------");
        System.out.println("How do you want to join us?");
        System.out.println("1. Sign Up");
        System.out.println("2. Log In");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) {
        displayMenu();
        while (true)
        {
            System.out.println("Please enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
                scanner.next();
                continue;
            }
            if (choice == 1) {
                User user = new User("", "", "");
                do {
                    readUserInfoSignUp(user);
                }
                while (!signUp.validate(user));
                curUser = user;
                usersManagment.addUser(user);
                addToJsonFile(user);
                break;
            } else if (choice == 2) {
                User user = new User("", "", "");
                do {
                    readUserInfoLogIn(user);
                }
                while (!logIn.validate(user));
                curUser = user;
                break;
            } else if (choice == 3) {
                System.out.println("Exiting...");
                return;
            } else {
                System.out.println("Invalid choice, please try again");
            }
        }

    }
}
