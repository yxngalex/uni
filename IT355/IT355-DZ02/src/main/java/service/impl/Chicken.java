package service.impl;

import service.Animal;

public class Chicken implements Animal {
    @Override
    public void makeSound() throws Throwable{
        System.out.println("Puk puk puk");
    }

    @Override
    public void feed() {
        System.out.println("Feeding chicken...");
    }
}
