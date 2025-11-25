import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator{
    
	public boolean isValidEmail(String email) {
		if(email == null)
		{
			return false;
		}
        if(email.isEmpty())
        {
            return false;
        }
		String rule = "[A-Za-z0-9]+@[A-Za-z0-9]+.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	}