package rs.ac.metropolitan.it355;

import java.util.ArrayList;
import java.util.List;

public class StockPrice {
    
    private List<String> listaSimbola = new ArrayList<>();
    
    public StockPrice() {
        listaSimbola.add("YHOO");
        listaSimbola.add("MCFT");
        listaSimbola.add("AAPL");
        listaSimbola.add("IBM");
        listaSimbola.add("MOJISTOCK");
    }

    public String calculatePrice(String simbol, int brojAkcija) {
        if (brojAkcija < 1) {
            brojAkcija = 1;
        }
        if (listaSimbola.contains(simbol)) {
            int randNumber = (1 + (int) (Math.random() * 100)) * brojAkcija;
            return "Cena akcija je: " + randNumber + ". Cena jedne akcije je : " + randNumber / brojAkcija;
        } else {
            return "Simbol nije podrzan";
        }
    }
}
