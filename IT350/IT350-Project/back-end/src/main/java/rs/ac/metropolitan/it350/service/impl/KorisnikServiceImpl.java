package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.KorisnikRepository;
import rs.ac.metropolitan.it350.service.KorisnikService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class KorisnikServiceImpl implements KorisnikService {
	private final KorisnikRepository korisnikRepository;

	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik findById(Integer idKorisnika) {
		return korisnikRepository.findById(idKorisnika)
				.orElseThrow(() -> new NoSuchElementException("KorisnikService.notFound"));
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public Korisnik update(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public void deleteById(Integer idKorisnika) {
		korisnikRepository.deleteById(idKorisnika);
	}


}