import java.util.Scanner;

public class Calcul8or_CLI {

  // Change the return types to private since they're only used within the class
  private static double num1;
  private static double num2;
  private static double calculation;

  private static Scanner myInput = new Scanner(System.in); // Declare this as a global variable

  public static void main(String[] args) {
    System.out.println("Welcome to the Calcul8or");
    System.out.println("Chose the number of the mathematical operation you would like to do from the list:");

    // Moved to multiple lines because it's easier to read
    System.out.println(
      "1. Addition \n" +
        "2. Subtraction \n" +
        "3. Multipication \n" +
        "4. Division \n" +
        "5. Exponents \n" +
        "6. SquareRoots"
    );
    decisionsPrompt();
  }

  private static void decisionsPrompt() {
    // Adding this statement to improve usability
    System.out.print("Option >>> ");
    int answer = (int) acceptInput();

    switch (answer) {
      case 1:
        addition();
        break;
      case 2:
        subtraction();
        break;
      case 3:
        multiplication();
        break;
      case 4:
        division();
        break;
      case 5:
        exponent();
        break;
      case 6:
        squareRoot();
        break;
      default:
        // Change this to default since you want to be able to handle cases like 0 and 8
        System.out.println("Please enter a valid number.");
        decisionsPrompt();
    }
  }

  private static void answerCalc() {
    System.out.println("The answer of your calculation is: " + calculation);
  }

  // Renamed to inputPrompt to make the objective of the method clearer
  private static void inputPrompt() {
    // Use this format to improve clarity
    // System.out.print keeps the cursor on the same line
    System.out.print("Enter the first number >>> ");
    num1 = acceptInput();

    System.out.print("Enter the second number >>> ");
    num2 = acceptInput();
  }

  // Renamed to squareRootPrompt to make the objective of the method clearer
  private static void squareRootPrompt() {
    System.out.print("Enter number to square root >>> ");
    num1 = acceptInput();
  }

  private static void addition() {
    inputPrompt();
    calculation = num1 + num2;
    answerCalc();
  }

  private static void subtraction() {
    inputPrompt();
    calculation = num1 - num2;
    answerCalc();
  }

  // Fixed typo :P
  private static void multiplication() {
    inputPrompt();
    calculation = num1 * num2;
    answerCalc();
  }

  private static void division() {
    inputPrompt();
    calculation = num1 / num2;
    answerCalc();
  }

  private static void exponent() {
    inputPrompt();
    calculation = Math.pow(num1, num2);
    answerCalc();
  }

  private static void squareRoot() {
    squareRootPrompt();
    calculation = Math.sqrt(num1);
    answerCalc();
  }

  // Create a helper method to assist with managing the Scanner state
  private static double acceptInput() {
    double input = myInput.nextDouble();

    // Use Scanner#nextLine to remove the new line feed after each input
    myInput.nextLine();
    return input;
  }
}
