 public class MyAnalysisCode {

        public static void main(String[] args) {
            int num1 = 5;
            int num2 = 10;
            String message = "The sum is: " + num1 + num2; // Intentional code smell: incorrect string concatenation order
            System.out.println(message);

            if (num1 > 0) {
                System.out.println("Number 1 is positive.");
            } else if (num1 == 0) { // Unnecessary 'else if' when 'else' could suffice
                System.out.println("Number 1 is zero.");
            }

            // Another intentional code smell: unused local variable
            int unusedVariable = 200;
            System.out.println("Main method finished.");
        }

        // An empty method is often considered a code smell or a placeholder for future logic
        public void doNothingMethod() {
            // This method currently does nothing.
        }
    }