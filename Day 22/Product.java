import java.io.*;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L; // Recommended for Serializable classes
	private int id;
	private String name;

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() { return id; }
	public String getName() { return name; }
}

class ProductSerializer {
	public static byte[] serializeProduct(Product p) throws IOException {
        if(p == null){
            return null;
        }else{
		try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos)){
		oos.writeObject(p);
		oos.flush();
		return bos.toByteArray();
	}catch(IOException e){return null;}
}}


	// Helper method for testing, not part of the main problem requirements
	public static Product deserializeProduct(byte[] data) throws IOException, ClassNotFoundException {
		try(ByteArrayInputStream bis = new ByteArrayInputStream(data);
		ObjectInputStream ois = new ObjectInputStream(bis)){
		return (Product) ois.readObject();}catch(IOException e){e.getMessage();return null;}catch(ClassNotFoundException e){e.getMessage();return null;}
    }}
