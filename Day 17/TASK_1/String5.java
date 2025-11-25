
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String5 {
    public static void main(String[] args) {
        String input = "another@domain";
        String rule = "^[a-zA-Z0-9.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(rule);
        Matcher match = pattern.matcher(input);

        System.out.println("Input validation: "+match.matches());
    }
}
