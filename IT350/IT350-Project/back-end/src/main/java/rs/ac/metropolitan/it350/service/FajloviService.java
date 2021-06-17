package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface FajloviService {

	List<Fajlovi> findAll();

	Fajlovi save(Fajlovi fajlovi);

	Fajlovi update(Fajlovi fajlovi);

	Fajlovi findById(Integer idFajla);

	void deleteById(Integer idFajla);

}