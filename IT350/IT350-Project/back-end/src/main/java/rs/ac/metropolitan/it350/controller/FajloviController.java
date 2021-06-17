package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/fajlovis")
@RequiredArgsConstructor
@CrossOrigin
public class FajloviController {
	private final FajloviService fajloviService;

	@GetMapping
	public ResponseEntity<List<Fajlovi>> getAll() {
		return ResponseEntity.ok(fajloviService.findAll());
	}

	@GetMapping("/{idFajla}")
	public ResponseEntity<Fajlovi> getById(@PathVariable Integer idFajla) {
		return ResponseEntity.ok(fajloviService.findById(idFajla));
	}

	@PostMapping
	public ResponseEntity<Fajlovi> save(@RequestBody Fajlovi fajlovi) {
		return ResponseEntity.status(201).body(fajloviService.save(fajlovi));
	}

	@PutMapping
	public ResponseEntity<Fajlovi> update(@RequestBody Fajlovi fajlovi) {
		return ResponseEntity.ok(fajloviService.update(fajlovi));
	}

	@DeleteMapping("/{idFajla}")
	public void deleteById(@PathVariable Integer idFajla) {
		fajloviService.deleteById(idFajla);
	}

}

