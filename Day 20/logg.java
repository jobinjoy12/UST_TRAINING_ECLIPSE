
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class logg {
    public static void main(String[] args) {
        int infoCount =0;
        int warnCount =0;
        int errCount =0;
        int totalCount = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("sample.log")))
        {
            String line;
            while((line = br.readLine())!= null)
            {
                totalCount++;
                String[] arr = null;
                for (int i = 0; i < 2; i++) {
                    arr = line.split(" ");
                }
                if(arr[2].equalsIgnoreCase("INFO"))
                {
                    infoCount++;
                }
                else if(arr[2].equalsIgnoreCase("ERROR"))
                {
                    errCount++;
                }
                else if(arr[2].equals("WARNING"))
                {
                    warnCount++;
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("Log Analysis Summary:");
            System.out.println("Total Number of lines processed: "+totalCount);
            System.out.println("INFO Messages: "+infoCount+", WARNING Messages: "+warnCount+", ERROR Messages: "+errCount);
        }catch(IOException e){System.out.println("Error: IO exception has occured");}
    }
}
