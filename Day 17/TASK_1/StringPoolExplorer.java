public class StringPoolExplorer {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        String s5 = "World";
        String s6 = "He" + "llo";
        String s7 = "Hello".intern();
        String s8 = new String("Hello").intern();

        System.out.println(s1==s2);//i predict true
        System.out.println(s1.equals(s2));//i predict true
        System.out.println(s1==s3); //i predict false
        System.out.println(s1.equals(s3));//i predict false
        System.out.println(s3==s4); //i predict false
        System.out.println(s3.equals(s4)); //i predict false
        System.out.println(s1 == s6);//i predict false;
        System.out.println(s1==s7);//i predict true;
        System.out.println(s3 == s7); //i predict false
        System.out.println(s1==s8);//i predict true
        System.out.println(s7==s8);//i predict true
    }

    //== method in java returns true if both the operands of this operator refers to the same reference , this is used for comparing references.
    //.equals method in java is used for comparing the value so if the refereneces are different but the values are the same then it will return the true.
    //I have observed that the String gets stored in the string pool when the new operator is not used and when the intern operator is used , in this both cases the String is stored in the String pool. when we used the new operator for creating a string then the string is crated in the heap memory.
    //intern is used for transferring the string from the heap memory to the string pool and if the string is already in the pool it will return the reference to that string .
    //intern method affects the == operator by if we are comparing with a string created with the new method then it will return false.    
}
