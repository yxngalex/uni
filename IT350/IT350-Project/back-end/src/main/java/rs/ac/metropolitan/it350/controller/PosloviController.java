package rs.ac.metropolitan.it350.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/poslovis")
@RequiredArgsConstructor
@CrossOrigin
public class PosloviController {
	private final PosloviService posloviService;

	@GetMapping
	public ResponseEntity<List<Poslovi>> getAll() {
		return ResponseEntity.ok(posloviService.findAll());
	}

	@GetMapping("/{idPosla}")
	public ResponseEntity<Poslovi> getById(@PathVariable Integer idPosla) {
		return ResponseEntity.ok(posloviService.findById(idPosla));
	}

	@PostMapping
	public ResponseEntity<Poslovi> save(@RequestBody Poslovi poslovi) {
		return ResponseEntity.status(201).body(posloviService.save(poslovi));
	}

	@PutMapping
	public ResponseEntity<Poslovi> update(@RequestBody Poslovi poslovi) {
		return ResponseEntity.ok(posloviService.update(poslovi));
	}

	@DeleteMapping("/{idPosla}")
	public void deleteById(@PathVariable Integer idPosla) {
		posloviService.deleteById(idPosla);
	}

}

