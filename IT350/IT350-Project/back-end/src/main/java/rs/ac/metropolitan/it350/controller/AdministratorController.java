package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/administrators")
@RequiredArgsConstructor
@CrossOrigin
public class AdministratorController {
	private final AdministratorService administratorService;

	@GetMapping
	public ResponseEntity<List<Administrator>> getAll() {
		return ResponseEntity.ok(administratorService.findAll());
	}

	@GetMapping("/{idAdministartora}")
	public ResponseEntity<Administrator> getById(@PathVariable Integer idAdministartora) {
		return ResponseEntity.ok(administratorService.findById(idAdministartora));
	}

	@PostMapping
	public ResponseEntity<Administrator> save(@RequestBody Administrator administrator) {
		return ResponseEntity.status(201).body(administratorService.save(administrator));
	}

	@PutMapping
	public ResponseEntity<Administrator> update(@RequestBody Administrator administrator) {
		return ResponseEntity.ok(administratorService.update(administrator));
	}

	@DeleteMapping("/{idAdministartora}")
	public void deleteById(@PathVariable Integer idAdministartora) {
		administratorService.deleteById(idAdministartora);
	}

}

