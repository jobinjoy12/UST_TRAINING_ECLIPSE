public class Jagged {
    public static void main(String[] args) {
        int[][] studentScores = new int[3][];
        studentScores[0] = new int[] {85, 78, 92, 88};
        studentScores[1] = new int[] {90, 76};
        studentScores[2] = new int[] {65, 70, 80, 75, 85};

        for (int i = 0; i < studentScores.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            int sum = 0;

            for (int num : studentScores[i]) {
                System.out.print(num + " ");
                
            }System.out.println();
        }
        for (int i = 0; i < studentScores.length; i++) {
            int sum = 0;
            for (int score : studentScores[i]) {
                sum += score;
            }
            double average = (double) sum / studentScores[i].length;
            System.out.println("Student "+ (i+1) +" - Sum: " + sum + ", Average: " + average);

        }
    }
}