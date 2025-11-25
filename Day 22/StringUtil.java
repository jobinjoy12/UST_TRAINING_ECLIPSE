public class StringUtil {
	public String reverseString(String str) {
        if(str == null){
            return null;}
            else{
		StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        System.out.println(reversed);
        return reversed;}}
	}
