package zadatak3;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main extends Application {

    //Idea je da se na FX-u progress bar loaduje u vidu animacije sve dok Jsoup u posebnoj niti preuzima podatke sa interneta
    private static ProgressBar bar = new ProgressBar(-1);
    private static TextArea tekst = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {

        bar.setPrefSize(300, 20);
        tekst.setMaxSize(800, 800);
        tekst.setEditable(false);

        BorderPane root = new BorderPane();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 100; i++) {
                        bar.setProgress(i);
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect("https://www.tutorialspoint.com/python").get();
                    Elements elements = doc.getElementsByClass("toc chapters");
                    Elements lista = elements.select("ul");
                    for (Element el : lista) {

                        Elements sekcija = el.select("li.heading");
                        Elements tutorijal = el.select("li a");

                        for (Element e : tutorijal) {
                            Elements li = e.select("a");
                            tekst.appendText("Sekcija: " + sekcija.text() + "\nTutorijal: " + li.text() + "\n");
                            tekst.appendText("----------------------------------------------------------------------------------------------------------------------------\n");
                            pauza(300);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });

        t1.start();
        t2.start();

        root.setTop(bar);
        root.setCenter(tekst);
        root.setPadding(new Insets(20));
        root.setAlignment(bar, Pos.CENTER);

        Scene scene = new Scene(root, 900, 900);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CS102-DZ10-Aleksa Cekic 4173");
        primaryStage.show();
        primaryStage.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void pauza(int milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
