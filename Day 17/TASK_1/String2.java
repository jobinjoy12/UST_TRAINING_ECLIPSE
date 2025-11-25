// Solution for Learner Hands-on Task: StringBuilder & StringBuffer
public class String2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("The quick brown fox ");
        sb.append("jumps over the lazy dog.");
        //inserting
        sb.insert(4,"really ");
        //deleting by counting beccause its said in the question        System.out.println(sb.delete(16,22).toString());
        
        StringBuffer sbuff = new StringBuffer("Mutable Strings Are Great!");
        sbuff.reverse();
        System.out.println(sbuff);
        
    
    }
}
