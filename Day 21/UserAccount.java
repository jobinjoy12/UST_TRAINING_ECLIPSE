
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserAccount implements Serializable
 {
    private String username;
    private transient String password;
    private String email;
    
    public UserAccount(String username , String password,String email)
    {
        this.username = username;
        this.password= password;
        this.email= email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString()
    {
        return "Username; "+username+" Password: "+password+" Email: "+email;
    }
}

public class Main{
    public static void main(String[] args) {
        UserAccount acc = new UserAccount("Jobin","12345","jobin123@ust");
        System.out.println(acc);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(acc);
            System.out.println("After Serialization: "+acc);
        } catch (Exception e) {e.getMessage();}
        
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
           acc = (UserAccount) ois.readObject();            
            System.out.println("After Deserialization: "+acc);
        } catch (Exception e) {e.getMessage();}
        }
    }
