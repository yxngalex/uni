package rs.ac.metropolitan.it350.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.it350.entity.Korisnik;

@Repository
public  interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

}