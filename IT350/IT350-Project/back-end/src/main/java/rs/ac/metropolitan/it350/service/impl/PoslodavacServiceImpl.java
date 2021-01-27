package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.PoslodavacRepository;
import rs.ac.metropolitan.it350.service.PoslodavacService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class PoslodavacServiceImpl implements PoslodavacService {
	private final PoslodavacRepository poslodavacRepository;

	@Override
	public List<Poslodavac> findAll() {
		return poslodavacRepository.findAll();
	}

	@Override
	public Poslodavac findById(Integer idPoslodavca) {
		return poslodavacRepository.findById(idPoslodavca)
				.orElseThrow(() -> new NoSuchElementException("PoslodavacService.notFound"));
	}

	@Override
	public Poslodavac save(Poslodavac poslodavac) {
		return poslodavacRepository.save(poslodavac);
	}

	@Override
	public Poslodavac update(Poslodavac poslodavac) {
		return poslodavacRepository.save(poslodavac);
	}

	@Override
	public void deleteById(Integer idPoslodavca) {
		poslodavacRepository.deleteById(idPoslodavca);
	}


}