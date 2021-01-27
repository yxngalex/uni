package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/ocenas")
@RequiredArgsConstructor
@CrossOrigin
public class OcenaController {
	private final OcenaService ocenaService;

	@GetMapping
	public ResponseEntity<List<Ocena>> getAll() {
		return ResponseEntity.ok(ocenaService.findAll());
	}

	@GetMapping("/{idOcene}")
	public ResponseEntity<Ocena> getById(@PathVariable Integer idOcene) {
		return ResponseEntity.ok(ocenaService.findById(idOcene));
	}

	@PostMapping
	public ResponseEntity<Ocena> save(@RequestBody Ocena ocena) {
		return ResponseEntity.status(201).body(ocenaService.save(ocena));
	}

	@PutMapping
	public ResponseEntity<Ocena> update(@RequestBody Ocena ocena) {
		return ResponseEntity.ok(ocenaService.update(ocena));
	}

	@DeleteMapping("/{idOcene}")
	public void deleteById(@PathVariable Integer idOcene) {
		ocenaService.deleteById(idOcene);
	}

}

