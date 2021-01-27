package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.RadnikRepository;
import rs.ac.metropolitan.it350.service.RadnikService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class RadnikServiceImpl implements RadnikService {
	private final RadnikRepository radnikRepository;

	@Override
	public List<Radnik> findAll() {
		return radnikRepository.findAll();
	}

	@Override
	public Radnik findById(Integer idRadnika) {
		return radnikRepository.findById(idRadnika)
				.orElseThrow(() -> new NoSuchElementException("RadnikService.notFound"));
	}

	@Override
	public Radnik save(Radnik radnik) {
		return radnikRepository.save(radnik);
	}

	@Override
	public Radnik update(Radnik radnik) {
		return radnikRepository.save(radnik);
	}

	@Override
	public void deleteById(Integer idRadnika) {
		radnikRepository.deleteById(idRadnika);
	}


}