public class String1{
    public static void main(String[] args) {
        String originalString = "Hello Java";
        System.out.println(originalString);

        //UpperCase
        String upperCaseString = originalString.toUpperCase();
        System.out.println(upperCaseString);
        System.out.println(originalString);

        //StringReplace
        String replacedString = originalString.replace("Java","World");
        System.out.println(replacedString);
        System.out.println(originalString);

        String concatenatedString = originalString.concat(", Welcome!");
        System.out.println(concatenatedString);
        System.out.println(originalString);

        //in this i have learned that String is immutable and that the functions i have used here like replace , concat creates a new object of string while the orginalString remains unchanged.
    }
}