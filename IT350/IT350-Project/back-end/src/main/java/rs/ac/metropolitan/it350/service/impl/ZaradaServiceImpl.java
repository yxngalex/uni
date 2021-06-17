package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.ZaradaRepository;
import rs.ac.metropolitan.it350.service.ZaradaService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class ZaradaServiceImpl implements ZaradaService {
	private final ZaradaRepository zaradaRepository;

	@Override
	public List<Zarada> findAll() {
		return zaradaRepository.findAll();
	}

	@Override
	public Zarada findById(Integer idZarade) {
		return zaradaRepository.findById(idZarade)
				.orElseThrow(() -> new NoSuchElementException("ZaradaService.notFound"));
	}

	@Override
	public Zarada save(Zarada zarada) {
		return zaradaRepository.save(zarada);
	}

	@Override
	public Zarada update(Zarada zarada) {
		return zaradaRepository.save(zarada);
	}

	@Override
	public void deleteById(Integer idZarade) {
		zaradaRepository.deleteById(idZarade);
	}


}