
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String6 {
    public static void main(String[] args) {
        String rule ="^#[A-Za-z0-9_]+";
        String input = "Just finished #coding a new #project! It was #challenging but #fun_time. #100DaysOfCode";

        Pattern pattern = Pattern.compile(rule);
        Matcher match = pattern.matcher(input);
        while(match.find())
        {
            System.out.println("Expected Matches: \""+match.group()+"\", ");
        }
    }
}
