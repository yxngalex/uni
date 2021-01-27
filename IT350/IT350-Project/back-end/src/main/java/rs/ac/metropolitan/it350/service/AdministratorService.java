package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface AdministratorService {

	List<Administrator> findAll();

	Administrator save(Administrator administrator);

	Administrator update(Administrator administrator);

	Administrator findById(Integer idAdministartora);

	void deleteById(Integer idAdministartora);

}