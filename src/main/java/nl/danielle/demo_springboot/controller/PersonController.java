package nl.danielle.demo_springboot.controller;

import nl.danielle.demo_springboot.exception.RecordNotFoundException;
import nl.danielle.demo_springboot.model.Persoon;
import nl.danielle.demo_springboot.repository.PersoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersoonRepository persoonRepository;

    @GetMapping(value = "/personen")
    public ResponseEntity getPersonen() {
        Iterable<Persoon> personen = persoonRepository.findAll();
        return ResponseEntity.ok(personen);
    }

    @GetMapping(value = "/personen/{nr}")
    public ResponseEntity getPerson(@PathVariable long nr) {
        try {
            Optional<Persoon> persoon = persoonRepository.findById(nr);
            return ResponseEntity.ok(persoon);
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }

    @PostMapping(value = "/personen")
    public ResponseEntity addPerson(@RequestBody Persoon persoon) {
        persoonRepository.save(persoon);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/personen/{nr}")
    public ResponseEntity deletePerson(@PathVariable long nr) {
        try {
            persoonRepository.deleteById(nr);
            return ResponseEntity.ok("Verwijderd");
        } catch (Exception ex) {
            throw new RecordNotFoundException();
        }
    }
}
