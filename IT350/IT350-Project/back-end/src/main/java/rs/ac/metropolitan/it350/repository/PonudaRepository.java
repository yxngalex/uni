package rs.ac.metropolitan.it350.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.it350.entity.Ponuda;

@Repository
public  interface PonudaRepository extends JpaRepository<Ponuda, Integer> {

}