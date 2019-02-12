import java.util.Scanner;

public class Calcul8or_CLI {

    static int answer;

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
    public static void addition()
    {

    }
    public static void subtraction()
    {

    }
    public static void multipication()
    {

    }
    public static void division()
    {

    }
    public static void exponent()
    {

    }
    public static void squareroot()
    {

    }
}
