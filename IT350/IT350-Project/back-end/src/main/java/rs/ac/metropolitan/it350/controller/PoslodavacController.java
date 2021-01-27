package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/poslodavacs")
@RequiredArgsConstructor
@CrossOrigin
public class PoslodavacController {
	private final PoslodavacService poslodavacService;

	@GetMapping
	public ResponseEntity<List<Poslodavac>> getAll() {
		return ResponseEntity.ok(poslodavacService.findAll());
	}

	@GetMapping("/{idPoslodavca}")
	public ResponseEntity<Poslodavac> getById(@PathVariable Integer idPoslodavca) {
		return ResponseEntity.ok(poslodavacService.findById(idPoslodavca));
	}

	@PostMapping
	public ResponseEntity<Poslodavac> save(@RequestBody Poslodavac poslodavac) {
		return ResponseEntity.status(201).body(poslodavacService.save(poslodavac));
	}

	@PutMapping
	public ResponseEntity<Poslodavac> update(@RequestBody Poslodavac poslodavac) {
		return ResponseEntity.ok(poslodavacService.update(poslodavac));
	}

	@DeleteMapping("/{idPoslodavca}")
	public void deleteById(@PathVariable Integer idPoslodavca) {
		poslodavacService.deleteById(idPoslodavca);
	}

}

