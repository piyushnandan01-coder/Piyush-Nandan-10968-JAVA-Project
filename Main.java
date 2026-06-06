import java.util.Scanner;
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero error! Cannot divide by 0.");
        }
        return a / b;
    }
}
class ScientificCalculator extends Calculator {
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    public double squareRoot(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid Input! Cannot calculate square root of a negative number.");
        }
        return Math.sqrt(number);
    }
    public double logarithm(double number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("Invalid Input! Logarithm is only defined for positive numbers.");
        }
        return Math.log(number);
    }
    public double sine(double angleDegrees) {
        return Math.sin(Math.toRadians(angleDegrees));
    }
    public double cosine(double angleDegrees) {
        return Math.cos(Math.toRadians(angleDegrees));
    }
    public double tangent(double angleDegrees) throws ArithmeticException {
        if (Math.abs(angleDegrees % 180) == 90) {
            throw new ArithmeticException("Undefined Result! Tangent is undefined at this angle.");
        }
        return Math.tan(Math.toRadians(angleDegrees));
    }
}
public class Main {
    public static void main(String[] args) {
        ScientificCalculator calc = new ScientificCalculator();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("=== SCIENTIFIC CALCULATOR PROFESSIONAL ===");
        System.out.println("Developed by: Piyush Nandan (ERP No: 10968)");
        System.out.println("Rungta International Skills University");
        System.out.println("===========================================");

        while (running) {
            System.out.println("\n----------- MENU -----------");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Power (a^b)");
            System.out.println("6. Square Root (√)");
            System.out.println("7. Logarithm (ln)");
            System.out.println("8. Trigonometric Functions (Sin/Cos/Tan)");
            System.out.println("E. Exit");
            System.out.print("Choose an operation / enter option: ");
            
            String choice = scanner.next().trim().toUpperCase();

            try {
                switch (choice) {
                    case "1":
                    case "+": {
                        System.out.print("Enter first number: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double num2 = scanner.nextDouble();
                        System.out.println("Result = " + calc.add(num1, num2));
                        break;
                    }
                    case "2":
                    case "-": {
                        System.out.print("Enter first number: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double num2 = scanner.nextDouble();
                        System.out.println("Result = " + calc.subtract(num1, num2));
                        break;
                    }
                    case "3":
                    case "*": {
                        System.out.print("Enter first number: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double num2 = scanner.nextDouble();
                        System.out.println("Result = " + calc.multiply(num1, num2));
                        break;
                    }
                    case "4":
                    case "/": {
                        System.out.print("Enter first number: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double num2 = scanner.nextDouble();
                        // Triggers the exception handling if num2 is 0
                        System.out.println("Result = " + calc.divide(num1, num2));
                        break;
                    }
                    case "5": {
                        System.out.print("Enter base number (a): ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent power (b): ");
                        double exp = scanner.nextDouble();
                        System.out.println("Result = " + calc.power(base, exp));
                        break;
                    }
                    case "6": {
                        System.out.print("Enter number: ");
                        double num = scanner.nextDouble();
                        System.out.println("Result = " + calc.squareRoot(num));
                        break;
                    }
                    case "7": {
                        System.out.print("Enter positive number for log(ln): ");
                        double num = scanner.nextDouble();
                        System.out.println("Result = " + calc.logarithm(num));
                        break;
                    }
                    case "8": {
                        System.out.println("Sub-Menu: 1. Sin | 2. Cos | 3. Tan");
                        System.out.print("Select Trig function (1-3): ");
                        int trigChoice = scanner.nextInt();
                        System.out.print("Enter angle in degrees: ");
                        double angle = scanner.nextDouble();
                        
                        if (trigChoice == 1) {
                            System.out.println("Result Sin(" + angle + ") = " + calc.sine(angle));
                        } else if (trigChoice == 2) {
                            System.out.println("Result Cos(" + angle + ") = " + calc.cosine(angle));
                        } else if (trigChoice == 3) {
                            System.out.println("Result Tan(" + angle + ") = " + calc.tangent(angle));
                        } else {
                            System.out.println("Invalid Trigonometric Selection.");
                        }
                        break;
                    }
                    case "E":
                        System.out.println("Thank you for using Scientific Calculator Professional! Exiting...");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Invalid Choice! Please select a valid option from the menu.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Exception Caught: Invalid Input! Please enter numeric values only.");
                scanner.next();
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Exception Caught: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
