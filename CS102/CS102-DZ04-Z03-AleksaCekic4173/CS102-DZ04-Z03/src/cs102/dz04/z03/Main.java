package cs102.dz04.z03;

import java.io.File;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {

    private Slider opacityLevel = new Slider(0, 1, 1);
    private ToggleGroup grupa = new ToggleGroup();
    private Slider bojaLevel = new Slider(0, 1, 0);
    private Slider rotacijaLevel = new Slider(0, 360, 0);
    private Label nazivPesme = new Label("Naziv pesme:");
    private Label pesma = new Label();
    private final Label opacityLabel = new Label("Opacity level: ");
    private final Label bojaLabel = new Label("Jacina boje: ");
    private final Label rotacijaLabel = new Label("Rotacija: ");
    private Button btnA = new Button("Azuriraj");
    private Button btnE = new Button("Izadji");
    private RadioButton sl1 = new RadioButton("Prva slika");
    private RadioButton sl2 = new RadioButton("Druga slika");
    private RadioButton sl3 = new RadioButton("Treca slika");
    private ListView lista = new ListView();
    private final ImageView slika1 = new ImageView("https://www.w3schools.com/css/img_lights.jpg");
    private final ImageView slika2 = new ImageView("https://www.w3schools.com/css/paris.jpg");
    private final ImageView slika3 = new ImageView("https://www.w3schools.com/css/img_forest.jpg");
    private Media pesma1 = new Media(new File("song1.mp3").toURI().toString());
    private Media pesma2 = new Media(new File("song2.mp3").toURI().toString());
    private Media pesma3 = new Media(new File("song3.mp3").toURI().toString());
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        ColorAdjust colorAdjust = new ColorAdjust();

        final Label opacityValue = new Label(Double.toString(opacityLevel.getValue()));
        final Label bojaValue = new Label(Double.toString(bojaLevel.getValue()));
        final Label rotacijaValue = new Label(Double.toString(rotacijaLevel.getValue()));

        sl1.setToggleGroup(grupa);
        sl2.setToggleGroup(grupa);
        sl3.setToggleGroup(grupa);

        HBox dugme = new HBox(10);
        dugme.getChildren().addAll(btnA, btnE);
        dugme.setAlignment(Pos.CENTER);

        HBox hb1 = new HBox(5);
        hb1.getChildren().addAll(opacityLabel, opacityValue);
        hb1.setAlignment(Pos.CENTER);

        HBox hb2 = new HBox(5);
        hb2.getChildren().addAll(bojaLabel, bojaValue);
        hb2.setAlignment(Pos.CENTER);

        HBox hb3 = new HBox(5);
        hb3.getChildren().addAll(rotacijaLabel, rotacijaValue);
        hb3.setAlignment(Pos.CENTER);

        HBox pesmice = new HBox(3);
        pesmice.getChildren().addAll(nazivPesme, pesma);
        pesmice.setAlignment(Pos.CENTER);

        VBox slideri = new VBox(10);
        slideri.getChildren().addAll(hb1, opacityLevel, hb2, bojaLevel, hb3, rotacijaLevel);
        slideri.setAlignment(Pos.CENTER);

        lista.getItems().add(sl1);
        lista.getItems().add(sl2);
        lista.getItems().add(sl3);

        root.setLeft(lista);
        root.setBottom(dugme);
        root.setRight(slideri);
        root.setTop(pesmice);

        root.getBottom().setStyle("-fx-background-color: lightgray;");
        root.getTop().setStyle("-fx-background-color: lightgray;");
        root.getRight().setStyle("-fx-background-color: lightblue;");
        root.getLeft().setStyle("-fx-background-color: lightblue;");

        btnA.setOnAction(e -> {
            if (sl1.isSelected()) {
                root.setCenter(slika1);
                opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slika1.setOpacity(newValue.doubleValue());
                        opacityValue.setText(String.format("%.2f", newValue));
                    }

                });
                bojaLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        colorAdjust.setBrightness(newValue.doubleValue());
                        slika1.setEffect(colorAdjust);
                        bojaValue.setText(String.format("%.2f", newValue));
                    }
                });
                rotacijaLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slika1.setRotate(newValue.doubleValue());
                        rotacijaValue.setText(String.format("%.2f", newValue));
                    }
                });
                mediaPlayer = new MediaPlayer(pesma1);
                mediaPlayer.play();
                pesma.setText("Bob Marley - Three Little Birds");
            } else if (sl2.isSelected()) {
                root.setCenter(slika2);
                opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slika2.setOpacity(newValue.doubleValue());
                        opacityValue.setText(String.format("%.2f", newValue));
                    }

                });
                bojaLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        colorAdjust.setBrightness(newValue.doubleValue());
                        slika2.setEffect(colorAdjust);
                        bojaValue.setText(String.format("%.2f", newValue));
                    }
                });
                rotacijaLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slika2.setRotate(newValue.doubleValue());
                        rotacijaValue.setText(String.format("%.2f", newValue));
                    }
                });
                mediaPlayer.stop();
                mediaPlayer = new MediaPlayer(pesma2);
                mediaPlayer.play();
                pesma.setText("Lil Uzi Vert - P2");
            } else if (sl3.isSelected()) {
                root.setCenter(slika3);
                opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slika3.setOpacity(newValue.doubleValue());
                        opacityValue.setText(String.format("%.2f", newValue));
                    }

                });
                bojaLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        colorAdjust.setBrightness(newValue.doubleValue());
                        slika3.setEffect(colorAdjust);
                        bojaValue.setText(String.format("%.2f", newValue));
                    }
                });
                rotacijaLevel.valueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        slika3.setRotate(newValue.doubleValue());
                        rotacijaValue.setText(String.format("%.2f", newValue));
                    }
                });
                mediaPlayer.stop();
                mediaPlayer = new MediaPlayer(pesma3);
                mediaPlayer.play();
                pesma.setText("Mac Miller - Complicated");
            }
        });

        btnE.setOnAction(e -> {
            primaryStage.close();
        });

        Scene scene = new Scene(root, 1420, 860);

        primaryStage.setTitle("CS102-DZ04-Z03 Aleksa Cekic 4173");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
