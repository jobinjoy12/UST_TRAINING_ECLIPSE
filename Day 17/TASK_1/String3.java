public class String3 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        for(int i=0;i<100_000;i++)
        {
            String st = "job";
            String newst = st + "in";
        }long end =System.nanoTime();
        long duration = end - start/1_000_000;
        //calcuclating duration
         //printing
        System.out.println("Elpased time for String concatenation: "+duration+"ms");

        StringBuilder sb = new StringBuilder("job");
        start = System.nanoTime();

        for(int i =0;i<100_000;i++)
        {
            sb.append("in");
        }        end = System.nanoTime();
        duration = end - start/1_000_000;
        System.out.println("Elpased time for StringBuilder concatenation: "+duration+"ms");
//Sure! Here's a plain text explanation:
//In Java, StringBuilder performs better than String when you're doing a lot of string modifications, like in loops. This is because of how they work in memory:
//- String is immutable, meaning once you create a String, it can't be changed. So every time you modify it (like adding more text), Java creates a new String object. This uses more memory and slows things down because of all the object creation and garbage collection.
//- StringBuilder is mutable, which means it can change its contents without creating new objects. It uses a resizable array internally, so when you append text, it just adds to the existing object. This makes it much faster and more memory-efficient for repeated changes.
//So, if you're building a string in a loop or doing many concatenations, StringBuilder is the better choice. Use String when you're working with fixed or small strings that don't change much.

    }
}
