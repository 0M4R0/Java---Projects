import java.util.Scanner;

public class App {

    // convert celsius to fahrenheit
    public static float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // convert fahrenheit to celsius
    public static float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // display menu
    public static void printMenu() {
            System.out.println("Temperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
        }

    // get user choice
    public static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            return -1;
        }
    }

    // main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int choice = getUserChoice(scanner);

        switch (choice) {
            // convert celsius to fahrenheit
            case 1:
                System.out.print("Enter the temperature in Celsius: ");
                float celsius = scanner.nextFloat();
                float fahrenheit = celsiusToFahrenheit(celsius);
                System.out.println("Celsius: " + celsius + " => Fahrenheit: " + fahrenheit);
                break;

            // convert fahrenheit to celsius
            case 2:
                System.out.print("Enter the temperature in Fahrenheit: ");
                float fahrenheit1 = scanner.nextFloat();
                float celsius1 = fahrenheitToCelsius(fahrenheit1);
                System.out.println("Fahrenheit: " + fahrenheit1 + " => Celsius: " + celsius1);
                break;
        
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();
    }
}
