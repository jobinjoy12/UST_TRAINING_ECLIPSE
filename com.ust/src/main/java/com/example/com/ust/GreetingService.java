package com.example.com.ust;

public class GreetingService {
	String greetingMessage ;
	public GreetingService(String message)
	{
		this.greetingMessage = message;
	}
	
	public void displayGreeting()
	{
		System.out.println(greetingMessage);
	}
	public String getGreetingMessage() {
		return greetingMessage;
	}
}
