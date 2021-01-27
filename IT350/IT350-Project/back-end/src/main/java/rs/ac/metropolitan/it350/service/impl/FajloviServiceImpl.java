package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.FajloviRepository;
import rs.ac.metropolitan.it350.service.FajloviService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class FajloviServiceImpl implements FajloviService {
	private final FajloviRepository fajloviRepository;

	@Override
	public List<Fajlovi> findAll() {
		return fajloviRepository.findAll();
	}

	@Override
	public Fajlovi findById(Integer idFajla) {
		return fajloviRepository.findById(idFajla)
				.orElseThrow(() -> new NoSuchElementException("FajloviService.notFound"));
	}

	@Override
	public Fajlovi save(Fajlovi fajlovi) {
		return fajloviRepository.save(fajlovi);
	}

	@Override
	public Fajlovi update(Fajlovi fajlovi) {
		return fajloviRepository.save(fajlovi);
	}

	@Override
	public void deleteById(Integer idFajla) {
		fajloviRepository.deleteById(idFajla);
	}


}