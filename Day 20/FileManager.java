
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void writeToFile(String filePath,String content)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath)))
        {
            bw.write(content);   
        }catch(IOException e){System.out.println("Error writing to "+filePath+": "+e.getMessage());}
    }

    public static String readFromFile(String filePath)
    {
    StringBuilder sb = new StringBuilder();
    boolean isFirst = true;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line=br.readLine())!=null) { 
                if(isFirst == false){
                    sb.append("\n");
                }
               sb.append(line);
                isFirst=false;
            }
        }catch(FileNotFoundException e){System.out.println("File not found at "+filePath);return null;}
        catch(IOException e){System.out.println("Error reading from "+filePath+": "+e.getMessage());return null;}
       
    return sb.toString();
}

public static void main(String[] args) {
    writeToFile("output.txt", " My name is Java");
    System.out.println(readFromFile("output.txt"));
    System.out.println(readFromFile("nonexistent.txt"));
}
}