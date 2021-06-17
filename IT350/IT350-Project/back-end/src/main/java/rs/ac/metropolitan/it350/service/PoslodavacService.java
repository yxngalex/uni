package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface PoslodavacService {

	List<Poslodavac> findAll();

	Poslodavac save(Poslodavac poslodavac);

	Poslodavac update(Poslodavac poslodavac);

	Poslodavac findById(Integer idPoslodavca);

	void deleteById(Integer idPoslodavca);

}