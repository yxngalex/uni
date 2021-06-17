package zadatak;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NevalidnaSifraException {
		Prodavnica p1 = new Prodavnica();
		List<Proizvod> pList1 = new ArrayList<>();
		p1.setNaziv("Mega");
		p1.setLokacija("Dubrava");
		Proizvod pp1 = new PrehrambreniProizvod();
		pp1.setNaziv("Mleko");
		pp1.setCena(120);
		pp1.setSifra("12d2");
		for (int i = 0; i < 5; i++) {
			pList1.add(pp1);
			p1.setProizvod(pList1);
			System.out.println(p1);
		}

		

	}
}
