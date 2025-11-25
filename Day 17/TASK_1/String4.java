
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String4 {
    public static void main(String[] args) {
        String rule = "\\d+";
        String input = "Product ID: 12345, Price: $99.99, Quantity: 10 units.";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find())
        {
            System.out.println("Expected Matches: "+matcher.group());
        }

    }
    
}
