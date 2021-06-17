package rs.ac.metropolitan.it350.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.it350.entity.*;

public  interface KorisnikService {

	List<Korisnik> findAll();

	Korisnik save(Korisnik korisnik);

	Korisnik update(Korisnik korisnik);

	Korisnik findById(Integer idKorisnika);

	void deleteById(Integer idKorisnika);

}