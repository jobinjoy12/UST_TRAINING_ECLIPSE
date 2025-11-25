public class StringMethods {
    public static void main(String[] args) {
        String rawMessage = "  * Hello World! This is a secret message. Code: XYZ-789. Do not share! * ";
        String cleanedMessage = rawMessage.trim();
        if(cleanedMessage.startsWith("*") && cleanedMessage.endsWith("*")){
            cleanedMessage = cleanedMessage.substring(1,cleanedMessage.length()-1);
        }
        String str = "Code: ";
        int strl = str.length();
        cleanedMessage = cleanedMessage.trim();
        System.out.println("Cleaned Message: "+cleanedMessage); //printing cleaned message
        System.out.println("Length: "+cleanedMessage.length());//prints length
        System.out.println("UpperCase: "+cleanedMessage.toUpperCase());//Uppercase
        System.out.println("Index of Secret: "+cleanedMessage.indexOf("secret"));
        System.out.println("Checking if the message contains Code: : "+cleanedMessage.contains("Code:"));
        int startIndex = cleanedMessage.indexOf("Code:");
        int endIndex = cleanedMessage.indexOf(".",startIndex);
        System.out.println("Secert Code: "+cleanedMessage.substring(startIndex+strl, endIndex));
        System.out.println(cleanedMessage.replace("secret","confidential"));//replacing
        System.out.println(cleanedMessage.startsWith("Hello World!"));//checking


    }
}
