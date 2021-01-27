package cs102.dz03.z03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class Main extends Application {

    private Button btnI = new Button("Izracunaj");
    private RadioButton rb1 = new RadioButton("Kvadratom");
    private RadioButton rb2 = new RadioButton("Pravougaonikom");
    private RadioButton rb3 = new RadioButton("Trouglom");
    private ToggleGroup group = new ToggleGroup();
    private TextField polje1 = new TextField();
    private TextField polje2 = new TextField();
    private TextField polje3 = new TextField();
    private Label l = new Label();
    private Label l1 = new Label();
    private Label lr = new Label();
    private Label r = new Label();
    private Text greska = new Text();
    private Font font1 = new Font("Helvetica", 14);

    @Override
    public void start(Stage primaryStage) {

        l.setText("Izracunaj povrsinu nad: ");
        l1.setText("Unesite stranice vaseg objekta");
        lr.setText("Rezultat je: ");

        polje1.setPromptText("Unesi stranicu a");
        polje2.setPromptText("Unesi stranicu b");
        polje3.setPromptText("Unesi stranicu c");

        l.setFont(font1);
        l1.setFont(font1);
        lr.setFont(font1);

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        VBox vb = new VBox(rb1, rb2, rb3);

        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.add(l, 0, 0);
        root.add(vb, 0, 1);
        root.add(l1, 3, 0);
        root.add(lr, 0, 3);
        root.add(r, 1, 3);
        root.add(polje1, 3, 1);
        root.add(polje2, 4, 1);
        root.add(polje3, 5, 1);
        root.add(btnI, 4, 3);
        root.add(greska, 0, 4);

        root.setStyle("-fx-background-color: lightblue");

        rb1.setOnMouseClicked(e -> {
            polje3.setEditable(false);
            polje3.setDisable(true);
            polje2.setEditable(false);
            polje2.setDisable(true);
        });

        rb2.setOnMouseClicked(e -> {
            polje3.setEditable(false);
            polje3.setDisable(true);
            polje2.setEditable(true);
            polje2.setDisable(false);
        });

        rb3.setOnMouseClicked(e -> {
            polje3.setEditable(true);
            polje3.setDisable(false);
            polje2.setEditable(true);
            polje2.setDisable(false);
        });

        greska.setFill(Color.RED);
        greska.setFont(font1);

        btnI.setOnAction(e -> {
            if (rb1.isSelected()) {
                double a = Double.parseDouble(polje1.getText());
                double rezultat = a * a;
                String tekst = String.valueOf(rezultat);
                r.setText(tekst);
                greska.setText("");
            } else if (rb2.isSelected()) {
                double a = Double.parseDouble(polje1.getText());
                double b = Double.parseDouble(polje2.getText());
                double rezultat = a * b;
                String tekst = String.valueOf(rezultat);
                r.setText(tekst);
                greska.setText("");
            } else if (rb3.isSelected()) {
                double a = Double.parseDouble(polje1.getText());
                double b = Double.parseDouble(polje2.getText());
                double c = Double.parseDouble(polje3.getText());
                double rezultat = a * b / 2;
                String tekst = String.valueOf(rezultat);
                r.setText(tekst);
                greska.setText("");
            } else {
                greska.setText("Greska, izaberite zeljeni oblik i popunite polja");
            }
        });

        Scene scene = new Scene(root, 700, 150);

        primaryStage.setTitle("CS102-DZ03-Z03 - Aleksa Cekic 4173");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
