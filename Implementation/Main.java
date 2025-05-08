import Users.*;
import Validation.*;
import Budget.BudgetManegement;
import Budget.Category;
import Transactions.*;
import Income.*;
import Notifications.*;
import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UsersManagment usersManagment = new UsersManagment();
    static File usersFile = new File("users.json");
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
        ArrayList<User> users;
        if (usersFile.length() == 0)
            users = new ArrayList<>();
        try (FileReader fileReader = new FileReader(usersFile)) {
            users = gson.fromJson(fileReader, userType);
            if (users == null)
                users = new ArrayList<>();
            users.add(user);
            try (FileWriter fileWriter = new FileWriter(usersFile)) {
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

        while (true) {
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
                handleSignUp();
            } else if (choice == 2) {
                handleLogin();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                return;
            } else {
                System.out.println("Invalid choice, please try again");
            }
        }
    }

    private static void handleSignUp() {
        User user = new User("", "", "");
        user.setValidation(new SignUp());
        Boolean first = true, signedUp = true;
        do {
            if (!first) {
                System.out.println("Do you want to sign up again? (y/n)");
                char answer = scanner.next().charAt(0);
                if (answer == 'n') {
                    signedUp = false;
                    break;
                }
            }
            readUserInfoSignUp(user);
            first = false;
        } while (!user.validate());

        if (signedUp) {
            curUser = user;
            usersManagment.addUser(user);
            updateUsers(user);
            budgetManagementLoop();
        }
    }

    private static void handleLogin() {
        User user = new User("", "", "");
        user.setValidation(new LogIn());
        Boolean first = true, loggedIn = true;
        do {
            if (!first) {
                System.out.println("Do you want to login again? (y/n)");
                char answer = scanner.next().charAt(0);
                if (answer == 'n') {
                    loggedIn = false;
                    break;
                }
            }
            readUserInfoLogIn(user);
            first = false;
        } while (!user.validate());

        if (loggedIn) {
            curUser = user;
            budgetManagementLoop();
        }
    }

    private static void budgetManagementLoop() {
        BudgetManegement budget = curUser.getBudgetManegement();
        budget.setNotification(new LastMonthSpending());

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Income Management");
            System.out.println("2. Transaction Management");
            System.out.println("3. Budget Management");
            System.out.println("4. Last Month Notification");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    incomeManagementMenu(budget);
                    break;
                case 2:
                    transactionManagementMenu(budget);
                    break;
                case 3:
                    budgetManagementMenu(budget);
                    break;
                case 4:
                    generateReport(budget);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void incomeManagementMenu(BudgetManegement budget) {
        while (true) {
            System.out.println("\nIncome Management");
            System.out.println("1. Add Income");
            System.out.println("2. Delete Income");
            System.out.println("3. Edit Income");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addIncomeSource(budget);
                    break;
                case 2:
                    deleteIncomeSource(budget);
                    break;
                case 3:
                    editIncomeSource(budget);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void transactionManagementMenu(BudgetManegement budget) {
        while (true) {
            System.out.println("\nTransaction Management");
            System.out.println("1. Add Transaction");
            System.out.println("2. Delete Transaction");
            System.out.println("3. Edit Transaction");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addTransaction(budget);
                    break;
                case 2:
                    deleteTransaction(budget);
                    break;
                case 3:
                    editTransaction(budget);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void budgetManagementMenu(BudgetManegement budget) {
        while (true) {
            System.out.println("\nBudget Management");
            System.out.println("1. Add Category");
            System.out.println("2. Delete Category");
            System.out.println("3. Edit Category");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCategory(budget);
                    break;
                case 2:
                    deleteCategory(budget);
                    break;
                case 3:
                    editCategory(budget);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addIncomeSource(BudgetManegement budget) {
        System.out.print("Enter income name: ");
        String name = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        budget.addIncomeSource(new IncomeSource(name, amount));
        System.out.println("Income source added!");
    }

    private static void deleteIncomeSource(BudgetManegement budget) {
        List<IncomeSource> sources = budget.getIncomeSources();
        if (sources.isEmpty()) {
            System.out.println("No income sources available");
            return;
        }

        System.out.println("Select income to delete:");
        for (int i = 0; i < sources.size(); i++) {
            IncomeSource source = sources.get(i);
            System.out.printf("%d. %s - %.2f\n", i + 1, source.getName(), source.getAmount());
        }

        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < sources.size()) {
            budget.removeIncomeSource(sources.get(index));
            System.out.println("Income source deleted!");
        } else {
            System.out.println("Invalid selection");
        }
    }

    private static void editIncomeSource(BudgetManegement budget) {
        List<IncomeSource> sources = budget.getIncomeSources();
        if (sources.isEmpty()) {
            System.out.println("No income sources available");
            return;
        }

        System.out.println("Select income to edit:");
        for (int i = 0; i < sources.size(); i++) {
            IncomeSource source = sources.get(i);
            System.out.printf("%d. %s - %.2f\n", i + 1, source.getName(), source.getAmount());
        }

        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < sources.size()) {
            IncomeSource oldSource = sources.get(index);
            System.out.print("Enter new name: ");
            String name = scanner.next();
            System.out.print("Enter new amount: ");
            double amount = scanner.nextDouble();
            budget.editIncomeSource(oldSource, new IncomeSource(name, amount));
            System.out.println("Income source updated!");
        } else {
            System.out.println("Invalid selection");
        }
    }

    private static void addTransaction(BudgetManegement budget) {
        System.out.print("Enter transaction name: ");
        String name = scanner.next();
        System.out.print("Enter category name: ");
        String category = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        Transaction transaction = new Transaction(name, category, amount);
        budget.addTransaction(transaction);

        for (Budget.Category c : budget.getCategories()) {
            if (c.getCategoryName().equals(category)) {
                c.setTotalAmount(c.getTotalAmount() + amount);
            }
        }
        System.out.println("Transaction added!");
    }

    private static void deleteTransaction(BudgetManegement budget) {
        List<Transaction> transactions = budget.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions available");
            return;
        }

        System.out.println("Select transaction to delete:");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.printf("%d. %s - %s - %.2f\n",
                    i + 1, t.getName(), t.getCategoryName(), t.getAmount());
        }

        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < transactions.size()) {
            Transaction toDelete = transactions.get(index);
            budget.removeTransaction(toDelete);
            for (Category c : budget.getCategories()) {
                if (c.getCategoryName().equals(toDelete.getCategoryName())) {
                    c.setTotalAmount(c.getTotalAmount() - toDelete.getAmount());
                }
            }
            System.out.println("Transaction deleted!");
        } else {
            System.out.println("Invalid selection");
        }
    }

    private static void editTransaction(BudgetManegement budget) {
        List<Transaction> transactions = budget.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transactions available");
            return;
        }

        System.out.println("Select transaction to edit:");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.printf("%d. %s - %s - %.2f\n",
                    i + 1, t.getName(), t.getCategoryName(), t.getAmount());
        }

        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < transactions.size()) {
            Transaction oldTransaction = transactions.get(index);
            System.out.print("Enter new name: ");
            String name = scanner.next();
            System.out.print("Enter new category: ");
            String category = scanner.next();
            System.out.print("Enter new amount: ");
            double amount = scanner.nextDouble();

            Transaction newTransaction = new Transaction(name, category, amount);
            budget.editTransaction(oldTransaction, newTransaction);

            for (Category c : budget.getCategories()) {
                if (c.getCategoryName().equals(oldTransaction.getCategoryName())) {
                    c.setTotalAmount(c.getTotalAmount() - oldTransaction.getAmount());
                }
                if (c.getCategoryName().equals(category)) {
                    c.setTotalAmount(c.getTotalAmount() + amount);
                }
            }
            System.out.println("Transaction updated!");
        } else {
            System.out.println("Invalid selection");
        }
    }

    private static void addCategory(BudgetManegement budget) {
        System.out.print("Enter category name: ");
        String name = scanner.next();
        System.out.print("Enter initial amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter spending limit: ");
        double limit = scanner.nextDouble();
        budget.addCategory(new Category(name, amount, limit));
        System.out.println("Category added!");
    }

    private static void deleteCategory(BudgetManegement budget) {
        List<Category> categories = budget.getCategories();
        if (categories.isEmpty()) {
            System.out.println("No categories available");
            return;
        }

        System.out.println("Select category to delete:");
        for (int i = 0; i < categories.size(); i++) {
            Category c = categories.get(i);
            System.out.printf("%d. %s (Limit: %.2f)\n",
                    i + 1, c.getCategoryName(), c.getSpendingLimit());
        }

        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < categories.size()) {
            budget.removeCategory(categories.get(index));
            System.out.println("Category deleted");
        } else {
            System.out.println("Invalid selection");
        }
    }

    private static void editCategory(BudgetManegement budget) {
        List<Category> categories = budget.getCategories();
        if (categories.isEmpty()) {
            System.out.println("No categories available");
            return;
        }

        System.out.println("Select category to edit:");
        for (int i = 0; i < categories.size(); i++) {
            Category c = categories.get(i);
            System.out.printf("%d. %s (Limit: %.2f)\n",
                    i + 1, c.getCategoryName(), c.getSpendingLimit());
        }

        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < categories.size()) {
            Category oldCategory = categories.get(index);
            System.out.print("Enter new name: ");
            String name = scanner.next();
            System.out.print("Enter new limit: ");
            double limit = scanner.nextDouble();
            budget.editCategory(oldCategory,
                    new Category(name, oldCategory.getTotalAmount(), limit));
            System.out.println("Category updated");
        } else {
            System.out.println("Invalid selection");
        }
    }

    private static void generateReport(BudgetManegement budget) {
        budget.sendNotification();
        System.out.println("\n=== Financial Summary ===");
        System.out.printf("Total Income: %.2f\n", budget.getTotalIncome());
        System.out.printf("Total Expenses: %.2f\n", budget.getTotalExpense());
        System.out.printf("Net Balance: %.2f\n",
                budget.getTotalIncome() - budget.getTotalExpense());
    }
}