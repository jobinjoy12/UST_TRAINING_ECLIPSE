package Question1;

class Animal {
	public Animal() {
		System.out.println("Animal constructor called.");
	}
	public void makeSound() {
		System.out.println("Animal makes a sound.");
	}
}

class Mammal extends Animal {
	public Mammal() {
		System.out.println("Mammal constructor called.");
	}
	@Override
	public void makeSound() {
		System.out.println("Mammal roars.");
	}
}

class Dog extends Mammal {
	{
		System.out.println("Dog instance initializer block.");
	}
	public Dog() {
		System.out.println("Dog constructor called.");
	}
	@Override
	public void makeSound() {
		super.makeSound();
		System.out.println("Dog barks.");
	}
}
