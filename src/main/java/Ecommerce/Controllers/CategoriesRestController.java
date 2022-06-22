
package Ecommerce.Controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Repositories.CategoryRepository;


@RestController
@RequestMapping("/categories")
//@AllArgsConstructor
public class CategoriesRestController {
    private  Logger logger = LoggerFactory.getLogger(AuthRestController.class);
    private CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        logger.debug("RESOURCE::REQUEST TO GET ALL CATEGORIES");
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }

	public CategoriesRestController(Logger logger, CategoryRepository categoryRepository) {
		super();
		this.logger = logger;
		this.categoryRepository = categoryRepository;
	}

	public CategoriesRestController() {
		super();
	}

    
}
