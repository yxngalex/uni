package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/zaradas")
@RequiredArgsConstructor
@CrossOrigin
public class ZaradaController {
	private final ZaradaService zaradaService;

	@GetMapping
	public ResponseEntity<List<Zarada>> getAll() {
		return ResponseEntity.ok(zaradaService.findAll());
	}

	@GetMapping("/{idZarade}")
	public ResponseEntity<Zarada> getById(@PathVariable Integer idZarade) {
		return ResponseEntity.ok(zaradaService.findById(idZarade));
	}

	@PostMapping
	public ResponseEntity<Zarada> save(@RequestBody Zarada zarada) {
		return ResponseEntity.status(201).body(zaradaService.save(zarada));
	}

	@PutMapping
	public ResponseEntity<Zarada> update(@RequestBody Zarada zarada) {
		return ResponseEntity.ok(zaradaService.update(zarada));
	}

	@DeleteMapping("/{idZarade}")
	public void deleteById(@PathVariable Integer idZarade) {
		zaradaService.deleteById(idZarade);
	}

}

