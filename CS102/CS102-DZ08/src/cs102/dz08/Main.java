package cs102.dz08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Label labela1 = new Label();
    private Label l = new Label();
    private TextField tf1 = new TextField();
    private Label labela2 = new Label();
    private TextField tf2 = new TextField();
    private Label labela3 = new Label();
    private TextField tf3 = new TextField();
    private Set<Student> lista = new HashSet<Student>();
    private Button dugme = new Button("Dodaj studenta");
    private Button drugoDugme = new Button("Submit");
    private RadioButton rb1 = new RadioButton("Sortiraj po imena");
    private RadioButton rb2 = new RadioButton("Sortiraj po prezimena");
    private RadioButton rb3 = new RadioButton("Sortiraj po indexu");
    private ToggleGroup group = new ToggleGroup();
    private List<String> listaImena = new ArrayList<String>();
    private List<String> listaPrezimena = new ArrayList<String>();
    private List<String> listaIndeksa = new ArrayList<String>();

    @Override
    public void start(Stage primaryStage) {

        labela1.setText("Unesite podatke o studentu:");
        l.setText("Unesite ime studenta: ");
        tf1.setPromptText("Ime");
        labela2.setText("Unesite prezime studenta: ");
        tf2.setPromptText("Prezime");
        labela3.setText("Unesite broj indeksa studenta: ");
        tf3.setPromptText("Broj indexa");

        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        HBox hb1 = new HBox(5);
        hb1.getChildren().addAll(l, tf1);
        hb1.setPadding(new Insets(10));

        HBox hb2 = new HBox(5);
        hb2.getChildren().addAll(labela2, tf2);
        hb2.setPadding(new Insets(10));

        HBox hb3 = new HBox(5);
        hb3.getChildren().addAll(labela3, tf3);
        hb3.setPadding(new Insets(10));

        VBox vb = new VBox(5);
        vb.getChildren().addAll(rb1, rb2, rb3);
        vb.setPadding(new Insets(10));

        GridPane root = new GridPane();
        root.add(labela1, 0, 0);
        root.add(hb1, 0, 1);
        root.add(hb2, 0, 2);
        root.add(hb3, 0, 3);
        root.add(vb, 0, 4);
        root.add(dugme, 0, 5);
        root.add(drugoDugme, 1, 5);
        root.setAlignment(Pos.CENTER);

        drugoDugme.setOnAction(e -> {
            if (rb1.isSelected()) {
                System.out.println("Stampam sortiranu listu studenta po imenu: ");
                for(Student s : lista){
                    listaImena.add(s.getIme());
                }
                Collections.sort(listaImena);
                System.out.println(listaImena);
            }
            if (rb2.isSelected()) {
                System.out.println("Stampam sortiranu listu studenta po prezimenu: ");
                for(Student s : lista){
                    listaPrezimena.add(s.getPrezime());
                }
                Collections.sort(listaPrezimena);
                System.out.println(listaPrezimena);
            }
            if (rb3.isSelected()) {
                System.out.println("Stampam sortiranu listu studenta po broju indeksa: ");
                for(Student s : lista){
                    listaIndeksa.add(s.getIndex());
                }
                Collections.sort(listaIndeksa);
                System.out.println(listaIndeksa);
            }
        });

        dugme.setOnAction(e -> {
            Student s = new Student();
            s.setIme(tf1.getText());
            s.setPrezime(tf2.getText());
            s.setIndex(tf3.getText());
            lista.add(s);
            tf1.clear();
            tf2.clear();
            tf3.clear();
        });

        Scene scene = new Scene(root, 750, 350);

        primaryStage.setTitle("CS102-DZ07-AleksaCekic4173");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
