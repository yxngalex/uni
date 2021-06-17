package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface PorukaService {

	List<Poruka> findAll();

	Poruka save(Poruka poruka);

	Poruka update(Poruka poruka);

	Poruka findById(Integer idPoruke);

	void deleteById(Integer idPoruke);

}