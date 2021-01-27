package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/radniks")
@RequiredArgsConstructor
@CrossOrigin
public class RadnikController {
	private final RadnikService radnikService;

	@GetMapping
	public ResponseEntity<List<Radnik>> getAll() {
		return ResponseEntity.ok(radnikService.findAll());
	}

	@GetMapping("/{idRadnika}")
	public ResponseEntity<Radnik> getById(@PathVariable Integer idRadnika) {
		return ResponseEntity.ok(radnikService.findById(idRadnika));
	}

	@PostMapping
	public ResponseEntity<Radnik> save(@RequestBody Radnik radnik) {
		return ResponseEntity.status(201).body(radnikService.save(radnik));
	}

	@PutMapping
	public ResponseEntity<Radnik> update(@RequestBody Radnik radnik) {
		return ResponseEntity.ok(radnikService.update(radnik));
	}

	@DeleteMapping("/{idRadnika}")
	public void deleteById(@PathVariable Integer idRadnika) {
		radnikService.deleteById(idRadnika);
	}

}

