package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class InterceptorLog {
    @Before("execution(* service.impl.Chicken.feed(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before");
        System.out.println("Chicken -> feed() method is being called!");
        System.out.println(joinPoint.getSignature().getName());
    }

    @After("execution(* service.impl.Dog.feed(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After");
        System.out.println("Dog -> feed() method is being called!");
        System.out.println(joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* service.impl.Sheep.feed())")
    public void throwAfter(JoinPoint joinPoint){
        System.out.println("AfterReturning");
        System.out.println("Dog -> feed() method is being called!");
        System.out.println(joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* service.impl.Dog.makeSound())", throwing = "exception")
    public void throwAfter(JoinPoint joinPoint, Throwable exception){
        System.out.println("AfterThrowing");
        System.out.println("Dog -> makeSound() method is being called!");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Exception: " + exception);
    }

    @Around("execution(* service.impl.Sheep.makeSound(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around");
        System.out.println("Sheep -> response() method is being called!");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Args: " + Arrays.toString(joinPoint.getArgs()));
    }
}
