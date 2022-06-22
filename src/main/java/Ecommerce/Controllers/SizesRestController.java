
package Ecommerce.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Repositories.SizeRepository;

@RestController
@RequestMapping("/sizes")
//@AllArgsConstructor
public class SizesRestController {

    private  SizeRepository sizeRepository;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(sizeRepository.findAll(), HttpStatus.OK);
    }

	public SizesRestController(SizeRepository sizeRepository) {
		super();
		this.sizeRepository = sizeRepository;
	}

	public SizesRestController() {
		super();
	}

    
}
