package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface RadnikService {

	List<Radnik> findAll();

	Radnik save(Radnik radnik);

	Radnik update(Radnik radnik);

	Radnik findById(Integer idRadnika);

	void deleteById(Integer idRadnika);

}