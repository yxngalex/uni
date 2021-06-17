package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.OcenaRepository;
import rs.ac.metropolitan.it350.service.OcenaService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class OcenaServiceImpl implements OcenaService {
	private final OcenaRepository ocenaRepository;

	@Override
	public List<Ocena> findAll() {
		return ocenaRepository.findAll();
	}

	@Override
	public Ocena findById(Integer idOcene) {
		return ocenaRepository.findById(idOcene)
				.orElseThrow(() -> new NoSuchElementException("OcenaService.notFound"));
	}

	@Override
	public Ocena save(Ocena ocena) {
		return ocenaRepository.save(ocena);
	}

	@Override
	public Ocena update(Ocena ocena) {
		return ocenaRepository.save(ocena);
	}

	@Override
	public void deleteById(Integer idOcene) {
		ocenaRepository.deleteById(idOcene);
	}


}