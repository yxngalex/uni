package service;

import org.springframework.beans.factory.annotation.Autowired;

public interface Animal {

    void makeSound() throws Throwable;
    void feed();

}
