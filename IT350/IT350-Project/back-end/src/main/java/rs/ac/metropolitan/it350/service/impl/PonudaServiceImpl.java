package rs.ac.metropolitan.it350.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.repository.PonudaRepository;
import rs.ac.metropolitan.it350.service.PonudaService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class PonudaServiceImpl implements PonudaService {
	private final PonudaRepository ponudaRepository;

	@Override
	public List<Ponuda> findAll() {
		return ponudaRepository.findAll();
	}

	@Override
	public Ponuda findById(Integer idPonude) {
		return ponudaRepository.findById(idPonude)
				.orElseThrow(() -> new NoSuchElementException("PonudaService.notFound"));
	}

	@Override
	public Ponuda save(Ponuda ponuda) {
		return ponudaRepository.save(ponuda);
	}

	@Override
	public Ponuda update(Ponuda ponuda) {
		return ponudaRepository.save(ponuda);
	}

	@Override
	public void deleteById(Integer idPonude) {
		ponudaRepository.deleteById(idPonude);
	}


}