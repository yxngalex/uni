package cs102.dz01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Label lPd = new Label();
    private Label lId = new Label();
    private Label lFn = new Label();
    private Label lMn = new Label();
    private Label lLn = new Label();
    private Label lEm = new Label();
    private Label lP = new Label();

    private static TextField tId = new TextField("986230914");
    private TextField tFn = new TextField();
    private TextField tMn = new TextField();
    private TextField tLn = new TextField();
    private TextField tEm = new TextField();
    private TextField tP = new TextField();

    private Button btnNew = new Button("New");
    private Button btnUpdate = new Button("Update");
    private Button btnDelete = new Button("Delete");
    private Button btnFirst = new Button("First");
    private Button btnPrevious = new Button("Previous");
    private Button btnNext = new Button("Next");
    private Button btnLast = new Button("Last");

    @Override
    public void start(Stage primaryStage) {

        lPd.setText("Person Details");
        lId.setText("ID");
        lFn.setText("First Name");
        lMn.setText("Middle Name");
        lLn.setText("Last Name");
        lEm.setText("Email");
        lP.setText("Phone");

        tId.setEditable(false);
        tId.setDisable(true);
        lPd.setStyle("-fx-background-color: white;");

        VBox root = new VBox();
        HBox hb = new HBox();

        hb.getChildren().addAll(btnNew, btnUpdate, btnDelete, btnFirst, btnPrevious, btnNext, btnLast);

        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        hb.setPadding(new Insets(12));

        GridPane gPane = new GridPane();

        gPane.add(lPd, 0, 0);
        gPane.add(lId, 0, 1);
        gPane.add(tId, 2, 1);
        gPane.add(lFn, 0, 2);
        gPane.add(tFn, 2, 2);
        gPane.add(lMn, 0, 3);
        gPane.add(tMn, 2, 3);
        gPane.add(lLn, 0, 4);
        gPane.add(tLn, 2, 4);
        gPane.add(lEm, 0, 5);
        gPane.add(tEm, 2, 5);
        gPane.add(lP, 0, 6);
        gPane.add(tP, 2, 6);
        //gPane.add(hb, 0, 7);
        gPane.setHgap(20);
        gPane.setVgap(5);
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(-10, 0, 5, 0));
       // gPane.setStyle("-fx-border-insets: 5;" + "-fx-border-color: gray;");

        root.getChildren().addAll(gPane, hb);
        root.setStyle("-fx-border-insets: 5;" + "-fx-border-color: gray;");
        Scene scene = new Scene(root, 710, 320);

        primaryStage.setTitle("CS102-DZ01-AleksaCekic4173");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
