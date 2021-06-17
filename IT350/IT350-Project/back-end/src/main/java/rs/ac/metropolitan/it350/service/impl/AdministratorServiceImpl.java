package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.AdministratorRepository;
import rs.ac.metropolitan.it350.service.AdministratorService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class AdministratorServiceImpl implements AdministratorService {
	private final AdministratorRepository administratorRepository;

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	@Override
	public Administrator findById(Integer idAdministartora) {
		return administratorRepository.findById(idAdministartora)
				.orElseThrow(() -> new NoSuchElementException("AdministratorService.notFound"));
	}

	@Override
	public Administrator save(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	@Override
	public Administrator update(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	@Override
	public void deleteById(Integer idAdministartora) {
		administratorRepository.deleteById(idAdministartora);
	}


}