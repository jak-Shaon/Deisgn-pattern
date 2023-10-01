class Animal 
{
    // Variable declaration with access modifier
    protected String name;

    // Constructor with parameter
    public Animal(String name) 
    {
        this.name = name;
    }

    // Method without parameters
    public void makeSound() 
    {
        System.out.println(name + " is making a sound.");
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) 
    {
        super(name);
        this.breed = breed;
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch(String item) {
        System.out.println(name + " is fetching the " + item + ".");
    }
}


public class Task_2 {
    public static void main(String[] args) 
    {
        //Object creation
        Dog dog = new Dog("Buddy", "Labrador");

        // Accessing inherited variable
        System.out.println("Name: " + dog.name);
        
        // Accessing variable of child class
        System.out.println("Breed: " + dog.breed);

        // Accessing inherited method
        dog.makeSound();
        
        // Accessing method of child class
        dog.bark();
        
        // Accessing method with parameter
        dog.fetch("ball");
    }
    
}
