package cs102.dz09;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private Rectangle square = new Rectangle(150, 150, Color.HOTPINK);

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        root.setCenter(square);

        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        square.setFill(Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256), 1.0));
                        Thread.sleep(10000);
                        square.setOpacity(0);
                        Thread.sleep(5000);
                        square.setOpacity(1);
                        square.setFill(Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256), 1.0));
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        }
        );
        th.start();
        
        Scene scene = new Scene(root, 450, 450);

        primaryStage.setTitle("CS102-DZ09");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
