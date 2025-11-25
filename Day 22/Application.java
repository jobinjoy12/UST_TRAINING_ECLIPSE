
import java.util.InputMismatchException;
import java.util.Scanner;


 class Main
{
    public static void main(String[] args) {
        System.out.println("enter two integer numbers");
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        int b = sc.nextInt();
        try {
           System.out.println((a/b));
        } catch (InputMismatchException e) {System.out.println("Invalid input: Please enter integers only.");
        } catch(ArithmeticException e){System.out.println("Error: Division by zero is not allowed.");

        }finally{System.out.println("Program executi complete");sc.close();}

        
   
    }
}