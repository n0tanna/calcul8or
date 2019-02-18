import java.util.Scanner;

public class Calcul8or_CLI {

    static int answer;
    static double num1;
    static double num2;
    static double calculation;

    public static void main(String[] args)
    {
        System.out.println("Welcome to the Calcul8or");
        System.out.println("Chose the number of the mathematical operation you would like to do from the list:");
        System.out.println("1. Addition \n2. Subtraction \n3. Multipication \n4. Division \n5. Exponents \n6. SquareRoots");
        decisions();
    }
    public static void decisions()
    {
        Scanner myInput = new Scanner(System.in);
        answer = myInput.nextInt();

        switch(answer)
        {
            case 1:
                addition();
                break;
            case 2:
                subtraction();
               break;
            case 3:
                multipication();
                break;
            case 4:
                division();
                break;
            case 5:
                exponent();
                break;
            case 6:
                squareroot();
                break;
            case 7:
                System.out.println("Please enter a valid number.");
                decisions();
        }
    }
    public static void numbers()
    {
        Scanner myInput = new Scanner(System.in);

        System.out.println("What is your first number?");
        num1 = myInput.nextDouble();

        System.out.println("What is your second number?");
        num2 = myInput.nextDouble();

    }
    public static void numbersSqrt()
    {
        Scanner myInput = new Scanner(System.in);

        System.out.println("What number would you like to sqrt?");
        num1 = myInput.nextDouble();
    }
    public static void answerCalc()
    {
        System.out.println("The answer of your calculation is: " + calculation);
    }
    public static void addition()
    {
        numbers();
        calculation = num1 + num2;
        answerCalc();
    }
    public static void subtraction()
    {
        numbers();
        calculation = num1 - num2;
        answerCalc();
    }
    public static void multipication()
    {
        numbers();
        calculation = num1 * num2;
        answerCalc();
    }
    public static void division()
    {
        numbers();
        calculation = num1 / num2;
        answerCalc();
    }
    public static void exponent()
    {
        numbers();
        calculation = Math.pow(num1, num2);
        answerCalc();
    }
    public static void squareroot()
    {
        numbersSqrt();
        calculation = Math.sqrt(num1);
        answerCalc();
    }
}
