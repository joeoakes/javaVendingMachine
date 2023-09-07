import java.util.Scanner;  // java.util is the package, Scanner is the class file to import

public class VendingMachine {
    public static void main(String[] args) {
        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
        Scanner scanner = new Scanner(System.in);

        // Define the available items and their prices
        // items is an array object items[0] "Soda"
        // prices is an array object price[0] 1.50
        String[] items = {"Soda", "Chips", "Candy", "Water"};
        double[] prices = {1.50, 1.00, 0.75, 1.25};

        // Display the menu
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available items:");

        // Iterate (loop) through the arrays items and prices using the length of the items array
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + 1 + ". " + items[i] + " - $" + prices[i]);
        }

        // Initialize the total amount
        double totalAmount = 0.0;

        // Endless loop condition until a breaks out of the loop condition
        while (true) {
            // Prompt the user for the item selection. Notice the type of input is interger
            System.out.print("Enter the item number (1-" + items.length + ") or 0 to exit: ");
            int choice = scanner.nextInt();

            //Handle the user input value 
            if (choice == 0) {
                break;  // Break out of the loop
            } else if (choice < 1 || choice > items.length) {
                System.out.println("Invalid choice. Please try again.");
            } else {
                int selectedItemIndex = choice - 1;
                String selectedItem = items[selectedItemIndex];
                double itemPrice = prices[selectedItemIndex];

                System.out.println("You selected: " + selectedItem);
                System.out.println("Price: $" + itemPrice);

                // Accept payment
                System.out.print("Insert coins (e.g., 1.00 for $1.00): $");
                double payment = scanner.nextDouble();  // Accept user input Double type

                if (payment < itemPrice) {
                    System.out.println("Insufficient payment. Please insert more coins.");
                } else {
                    // Dispense item
                    System.out.println("Dispensing " + selectedItem);
                    totalAmount += itemPrice;
                    double change = payment - itemPrice;  // Change value to return to the user
                    if (change > 0) {
                        System.out.println("Change: $" + change);
                    }
                }
            }
        }

        // Display the total amount earned
        System.out.println("Thank you for using the Vending Machine!");
        System.out.println("Total amount earned: $" + totalAmount);

        // Always close input, open connections to files, database,& networking
        scanner.close();
    }
}
