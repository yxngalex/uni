package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface ZaradaService {

	List<Zarada> findAll();

	Zarada save(Zarada zarada);

	Zarada update(Zarada zarada);

	Zarada findById(Integer idZarade);

	void deleteById(Integer idZarade);

}