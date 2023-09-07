import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
        Scanner scanner = new Scanner(System.in);

        // Define the available items and their prices
        String[] items = {"Soda", "Chips", "Candy", "Water"};
        double[] prices = {1.50, 1.00, 0.75, 1.25};

        // Display the menu
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available items:");

        for (int i = 0; i < items.length; i++) {
            System.out.println(i + 1 + ". " + items[i] + " - $" + prices[i]);
        }

        // Initialize the total amount
        double totalAmount = 0.0;

        while (true) {
            System.out.print("Enter the item number (1-" + items.length + ") or 0 to exit: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
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
                double payment = scanner.nextDouble();

                if (payment < itemPrice) {
                    System.out.println("Insufficient payment. Please insert more coins.");
                } else {
                    // Dispense item
                    System.out.println("Dispensing " + selectedItem);
                    totalAmount += itemPrice;
                    double change = payment - itemPrice;
                    if (change > 0) {
                        System.out.println("Change: $" + change);
                    }
                }
            }
        }

        // Display the total amount earned
        System.out.println("Thank you for using the Vending Machine!");
        System.out.println("Total amount earned: $" + totalAmount);

        scanner.close();
    }
}
