package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/porukas")
@RequiredArgsConstructor
@CrossOrigin
public class PorukaController {
	private final PorukaService porukaService;

	@GetMapping
	public ResponseEntity<List<Poruka>> getAll() {
		return ResponseEntity.ok(porukaService.findAll());
	}

	@GetMapping("/{idPoruke}")
	public ResponseEntity<Poruka> getById(@PathVariable Integer idPoruke) {
		return ResponseEntity.ok(porukaService.findById(idPoruke));
	}

	@PostMapping
	public ResponseEntity<Poruka> save(@RequestBody Poruka poruka) {
		return ResponseEntity.status(201).body(porukaService.save(poruka));
	}

	@PutMapping
	public ResponseEntity<Poruka> update(@RequestBody Poruka poruka) {
		return ResponseEntity.ok(porukaService.update(poruka));
	}

	@DeleteMapping("/{idPoruke}")
	public void deleteById(@PathVariable Integer idPoruke) {
		porukaService.deleteById(idPoruke);
	}

}

