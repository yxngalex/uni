package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.PosloviRepository;
import rs.ac.metropolitan.it350.service.PosloviService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class PosloviServiceImpl implements PosloviService {
	private final PosloviRepository posloviRepository;

	@Override
	public List<Poslovi> findAll() {
		return posloviRepository.findAll();
	}

	@Override
	public Poslovi findById(Integer idPosla) {
		return posloviRepository.findById(idPosla)
				.orElseThrow(() -> new NoSuchElementException("PosloviService.notFound"));
	}

	@Override
	public Poslovi save(Poslovi poslovi) {
		return posloviRepository.save(poslovi);
	}

	@Override
	public Poslovi update(Poslovi poslovi) {
		return posloviRepository.save(poslovi);
	}

	@Override
	public void deleteById(Integer idPosla) {
		posloviRepository.deleteById(idPosla);
	}


}