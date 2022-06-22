package Ecommerce.Controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Projection.ProductVW;
import Ecommerce.Services.ProductService;


@RestController
@RequestMapping("/products")
//@AllArgsConstructor
public class ProductRestController {
    private  Logger logger = LoggerFactory.getLogger(AuthRestController.class);
    private  ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "sort", required = true) String sort,
                                    @RequestParam(name = "page", required = true) int page,
                                    @RequestParam(name = "size", required = true) int size) {
        logger.debug("RESOURCE::REQUEST TO GET PRODUCT");
        return productService.findAllPageable(page, size, sort);

    }

    @GetMapping(value = "/any")
    public ResponseEntity<?> getAny(
            @RequestParam(name = "page", required = true) int page,
            @RequestParam(name = "size", required = true) int size,
            @RequestParam(name = "param", required = true) String param,
            @RequestParam(name = "sort", required = true) String sort) {
        return productService.findAny(param, sort, page, size);

    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> create(ProductVW productVW) {
        logger.debug("RESOURCE::REQUEST TO CREATE NEW PRODUCT {}", productVW);
        return productService.create(productVW);
    }
//
	public ProductRestController(Logger logger, ProductService productService) {
		super();
		this.logger = logger;
		this.productService = productService;
	}

	public ProductRestController() {
		super();
	}

    
    
}
