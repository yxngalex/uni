package service.impl;

import service.Animal;

public class Sheep implements Animal {
    @Override
    public void makeSound() throws Throwable{
        System.out.println("Bwaak Bwaaaak");
    }

    @Override
    public void feed() {
        System.out.println("Feeding sheep...");
    }
}
