import java.io.*;
import java.util.List;

class ContactInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	String email;
	String phone;

	public ContactInfo(String email, String phone) {
		this.email = email;
		this.phone = phone;
	}
	// Getters and Setters
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	@Override public String toString() { return "ContactInfo{email='" + email + "', phone='" + phone + "'}"; }
}

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int id;
	ContactInfo contactInfo;

	public Employee(String name, int id, ContactInfo contactInfo) {
		this.name = name;
		this.id = id;
		this.contactInfo = contactInfo;
	}
	// Getters and Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public ContactInfo getContactInfo() { return contactInfo; }
	public void setContactInfo(ContactInfo contactInfo) { this.contactInfo = contactInfo; }
	@Override public String toString() { return "Employee{name='" + name + "', id=" + id + ", contactInfo=" + contactInfo + "}"; }
}

class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	List<Employee> employees;

	public Department(String name, List<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}
	// Getters and Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public List<Employee> getEmployees() { return employees; }
	public void addEmployee(Employee emp) { this.employees.add(emp); }
	@Override public String toString() { return "Department{name='" + name + "', employees=" + employees + "}"; }

	public Department deepClone() throws IOException, ClassNotFoundException {
		// Your code here: Implement deep cloning using serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"))){
            oos.writeObject(this);
        }catch (IOException e) {System.out.println(e.getMessage());}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.txt"))){
            Department dept = (Department) ois.readObject();
			return dept;
        }catch(IOException e){throw e;}catch(ClassNotFoundException e){throw e;}
	}
}