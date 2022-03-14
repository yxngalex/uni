package service.impl;

import service.Animal;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }

    @Override
    public void feed() {
        System.out.println("Feeding dog...");
    }
}
