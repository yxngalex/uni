import aspect.InterceptorLog;
import config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Animal;
import service.impl.Chicken;
import service.impl.Dog;
import service.impl.Sheep;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        InterceptorLog log = context.getBean("log", InterceptorLog.class);
        Animal chicken = context.getBean("chicken", Animal.class);
        Animal dog = context.getBean("dog", Animal.class);
        Animal sheep = context.getBean("sheep", Animal.class);
        try {
            chicken.feed();
            chicken.makeSound();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            dog.feed();
            dog.makeSound();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            sheep.feed();
            sheep.makeSound();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
