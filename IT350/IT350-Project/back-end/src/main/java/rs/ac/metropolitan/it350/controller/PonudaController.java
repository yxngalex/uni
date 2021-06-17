package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/ponudas")
@RequiredArgsConstructor
@CrossOrigin
public class PonudaController {
	private final PonudaService ponudaService;

	@GetMapping
	public ResponseEntity<List<Ponuda>> getAll() {
		return ResponseEntity.ok(ponudaService.findAll());
	}

	@GetMapping("/{idPonude}")
	public ResponseEntity<Ponuda> getById(@PathVariable Integer idPonude) {
		return ResponseEntity.ok(ponudaService.findById(idPonude));
	}

	@PostMapping
	public ResponseEntity<Ponuda> save(@RequestBody Ponuda ponuda) {
		return ResponseEntity.status(201).body(ponudaService.save(ponuda));
	}

	@PutMapping
	public ResponseEntity<Ponuda> update(@RequestBody Ponuda ponuda) {
		return ResponseEntity.ok(ponudaService.update(ponuda));
	}

	@DeleteMapping("/{idPonude}")
	public void deleteById(@PathVariable Integer idPonude) {
		ponudaService.deleteById(idPonude);
	}

}

