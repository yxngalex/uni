package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface PosloviService {

	List<Poslovi> findAll();

	Poslovi save(Poslovi poslovi);

	Poslovi update(Poslovi poslovi);

	Poslovi findById(Integer idPosla);

	void deleteById(Integer idPosla);

}