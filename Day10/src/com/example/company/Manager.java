package com.example.company;
import com.example.company.Employee;

public class Manager extends Employee{
	public String projectName ;
	
	public Manager(String name , int id , String department , double salary , String projectName) {
		super(name,id,department,salary);
		this.projectName = projectName;
		
	}
	public void displayManagerDetails(){
		System.out.println("Name: "+name+" Department: "+department+" ProjectName: "+projectName);
	}
}
//you can directly access department, id ,salary but you cant access name since its a private member.
