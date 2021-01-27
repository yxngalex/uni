package cs102.dz02.z03;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    private FileChooser fc = new FileChooser();
    private Button btn = new Button("Klikni me");
    private StackPane root = new StackPane();
    File fileSelector = null;
    Scanner input;

    @Override
    public void start(Stage primaryStage) throws Exception {

        btn.setOnAction(e -> {
            fileSelector = fc.showOpenDialog(primaryStage);
            try {
                input = new Scanner(fileSelector);
                while (input.hasNextLine()) {
                    System.out.println(input.nextLine());
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().add(btn);
        root.setStyle("-fx-background-color: #ff69b4");
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("CS102-DZ02-Z03 Aleksa Cekic 4173");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
