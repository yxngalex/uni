package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface PonudaService {

	List<Ponuda> findAll();

	Ponuda save(Ponuda ponuda);

	Ponuda update(Ponuda ponuda);

	Ponuda findById(Integer idPonude);

	void deleteById(Integer idPonude);

}