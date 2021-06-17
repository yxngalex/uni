package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface OcenaService {

	List<Ocena> findAll();

	Ocena save(Ocena ocena);

	Ocena update(Ocena ocena);

	Ocena findById(Integer idOcene);

	void deleteById(Integer idOcene);

}