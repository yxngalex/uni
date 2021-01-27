package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.PorukaRepository;
import rs.ac.metropolitan.it350.service.PorukaService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class PorukaServiceImpl implements PorukaService {
	private final PorukaRepository porukaRepository;

	@Override
	public List<Poruka> findAll() {
		return porukaRepository.findAll();
	}

	@Override
	public Poruka findById(Integer idPoruke) {
		return porukaRepository.findById(idPoruke)
				.orElseThrow(() -> new NoSuchElementException("PorukaService.notFound"));
	}

	@Override
	public Poruka save(Poruka poruka) {
		return porukaRepository.save(poruka);
	}

	@Override
	public Poruka update(Poruka poruka) {
		return porukaRepository.save(poruka);
	}

	@Override
	public void deleteById(Integer idPoruke) {
		porukaRepository.deleteById(idPoruke);
	}


}