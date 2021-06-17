package rs.ac.metropolitan.it350.controller;

import java.util.List;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.it350.entity.*;
import rs.ac.metropolitan.it350.service.*;

@RestController
@RequestMapping("/korisniks")
@RequiredArgsConstructor
@CrossOrigin
public class KorisnikController {
    private final KorisnikService korisnikService;

    @GetMapping
    public ResponseEntity<List<Korisnik>> getAll() {
        return ResponseEntity.ok(korisnikService.findAll());
    }

    @GetMapping("/{idKorisnika}")
    public ResponseEntity<Korisnik> getById(@PathVariable Integer idKorisnika) {
        return ResponseEntity.ok(korisnikService.findById(idKorisnika));
    }

    @PostMapping
    public ResponseEntity<Korisnik> save(@RequestBody Korisnik korisnik) {
        return ResponseEntity.status(201).body(korisnikService.save(korisnik));
    }

    @PutMapping
    public ResponseEntity<Korisnik> update(@RequestBody Korisnik korisnik) {
        return ResponseEntity.ok(korisnikService.update(korisnik));
    }

    @DeleteMapping("/{idKorisnika}")
    public void deleteById(@PathVariable Integer idKorisnika) {
        korisnikService.deleteById(idKorisnika);
    }

}

