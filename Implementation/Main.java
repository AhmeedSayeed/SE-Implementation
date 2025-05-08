import Users.*;
import Validation.*;
import com.google.gson.*; // Gson Library to deal with JSON Files
import java.io.*; // For File Reader/Writer
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UsersManagment usersManagment = new UsersManagment();
    static String filePath = "users.json";
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

    public static void updateUsers(User user) {
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
        while (true)
        {
            displayMenu();
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
                user.setValidation(new SignUp());
                Boolean first = true, signedUp = true;
                do {
                    if(!first) {
                        System.out.println("Do you want to sign up again? (y/n)");
                        char answer = scanner.next().charAt(0);
                        if(answer == 'n') {
                            signedUp = false;
                            break;
                        }
                    }
                    readUserInfoSignUp(user);
                    first = false;
                }
                while (!user.validate());
                if(signedUp) {
                    curUser = user;
                    usersManagment.addUser(user);
                    updateUsers(user);
                }
                else
                    continue;
                break;
            } else if (choice == 2) {
                User user = new User("", "", "");
                user.setValidation(new LogIn());
                Boolean first = true, loggedIn = true;
                do {
                    if(!first) {
                        System.out.println("Do you want to login again? (y/n)");
                        char answer = scanner.next().charAt(0);
                        if(answer == 'n') {
                            loggedIn = false;
                            break;
                        }
                    }
                    readUserInfoLogIn(user);
                    first = false;
                }
                while (!user.validate());
                if(loggedIn)
                    curUser = user;
                else
                    continue;
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
