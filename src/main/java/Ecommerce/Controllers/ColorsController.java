
package Ecommerce.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ecommerce.Entities.Color;
import Ecommerce.Repositories.ColorRepository;

import java.util.List;


@RestController
@RequestMapping("/colors")
//@AllArgsConstructor
@Slf4j
public class ColorsController {
    private  ColorRepository colorRepository;
    
    //log
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ColorsController.class);

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.debug("RESOURCE::REQUEST TO GET ALL COLORS");
        // todo fix the pagination request
        Pageable page = PageRequest.of(0, 100);
        return ResponseEntity.ok().body(colorRepository.findAll(page));

    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByName(@PathVariable(name = "name") String name) {
        log.debug("RESOURCE::REQUEST TO GET BY NAME {}", name);
        // todo fix the pagination request
        Pageable page = PageRequest.of(0, 100);
        Page<List<Color>> findByNameContainingIgnoreCase = colorRepository.findByNameContainingIgnoreCase(name, page);
        return new ResponseEntity<>(findByNameContainingIgnoreCase, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody List<Color> color) {
        log.debug("RESOURCE::REQUEST TO POST COLORS {}", color);
        List<Color> saveAll = colorRepository.saveAll(color);
        return new ResponseEntity<>(saveAll, HttpStatus.CREATED);
    }
//
	public ColorsController(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	public ColorsController() {
		super();
	}

    
    
}
