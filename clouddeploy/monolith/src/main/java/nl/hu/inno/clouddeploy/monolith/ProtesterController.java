package nl.hu.inno.clouddeploy.monolith;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/protesters")
public class ProtesterController {

    private final EntityManager entities;

    public record UpdateProtesterDTO(String name) {
    }

    public record ProtesterDTO(Long id, String name) {
        public ProtesterDTO(Protester s) {
            this(s.getId(), s.getName());
        }
    }

    public ProtesterController(EntityManager entities) {
        this.entities = entities;
    }

    @GetMapping
    public List<ProtesterDTO> getProtesters() {
        List<Protester> protesters = entities.createQuery("select t from Protester t", Protester.class).getResultList();
        return protesters.stream().map(ProtesterDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<ProtesterDTO> createProtester(@RequestBody UpdateProtesterDTO dto) {
        Protester s = new Protester(dto.name());
        entities.persist(s);
        return ResponseEntity.created(URI.create(String.format("/protesters/%s", s.getId()))).body(new ProtesterDTO(s));
    }

    private Protester findProtester(Long id) {
        Protester s = entities.find(Protester.class, id);
        if (s == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return s;
    }

    @GetMapping("/{id}")
    public ProtesterDTO getProtester(@PathVariable("id") Long id) {
        return new ProtesterDTO(findProtester(id));
    }

    @PutMapping("/{id}")
    public ProtesterDTO updateProtester(@PathVariable("id") Long id, @RequestBody UpdateProtesterDTO dto) {
        Protester s = findProtester(id);
        s.update(dto.name());
        return new ProtesterDTO(s);
    }

    @DeleteMapping("/{id}")
    public void deleteProtester(@PathVariable("id") Long id) {
        Protester s = findProtester(id);
        entities.remove(s);
    }


}
