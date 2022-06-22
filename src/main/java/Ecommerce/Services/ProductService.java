package Ecommerce.Services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Ecommerce.Entities.*;
import Ecommerce.Exceptions.FileStorageException;
import Ecommerce.Projection.ProductVW;
import Ecommerce.Repositories.*;

import java.util.List;
import java.util.stream.Collectors;


@Service
//@AllArgsConstructor
public class ProductService {

    private ColorRepository colorRepository;
    private  CategoryRepository categoryRepository;
    private  ProductRepository productRepository;
    private  SizeRepository sizeRepository;
    private  UserRepository userRepository;
    private  FileService fileService;

    @Transactional
    public ResponseEntity<?> create(ProductVW productVW) {

        //check required media file in product
        int filesCount = productVW.getFiles().size();
        if (filesCount <= 0) {
            throw new FileStorageException("Product must contain at least one  Image Or Video");
        }
        List<File> files = productVW.getFiles().stream()
                .map(fileService::storeFiles).collect(Collectors.toList());

        List<Size> sizes = productVW.getSizes()
                .stream()
                .distinct()
                .collect(Collectors.toList())
                .stream()
                .map(sizeRepository::getOne)
                .collect(Collectors.toList());

        List<Category> categories = productVW.getCategories()
                .stream()
                .distinct()
                .collect(Collectors.toList())
                .stream().map(categoryRepository::getOne).collect(Collectors.toList());

        List<Color> colors = productVW.getColors()
                .stream()
                .distinct()
                .collect(Collectors.toList()).stream()
                .map(colorRepository::getOne).collect(Collectors.toList());

        Product product = new Product();
//        Faker faker = new Faker();
//=================********FAKE DATA OF PRODUCT*********============================//
//        product.setGender(faker.hipster().word());
//        product.setProductionDate(faker.date().past(1000, TimeUnit.DAYS));
//        product.setQuantity(faker.random().nextInt(0, 15000));
//        product.setPrice(Double.valueOf(faker.commerce().price(1.99, 3.9999)));
//        product.setName(faker.commerce().productName());
//        product.setCode(faker.commerce().promotionCode());
//=================********REAL DATA OF PRODUCT *********============================//
        product.setGender(productVW.getGender());
        product.setProductionDate(productVW.getProductionDate());
        product.setQuantity(productVW.getQuantity());
        product.setPrice(productVW.getPrice());
        product.setName(productVW.getName());
        product.setCode(productVW.getCode());
        product.setDescription(productVW.getDescription());
        product.setColors(colors);
        product.setCategories(categories);
        product.setSizes(sizes);
        product.setFiles(files);
        Product save = productRepository.save(product);
        System.out.println(save.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    public ResponseEntity<?> delete(Long id) {

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> update(Long id, Product product) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     * @param page
     * @param size
     * @param sort
     * @return Page products
     */
    @Transactional(readOnly = true)
    public ResponseEntity<?> findAllPageable(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return new ResponseEntity<>(productRepository.findAll(pageable), HttpStatus.OK);
    }

    public ResponseEntity<?> findByName(String name) {

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> findById(Long id) {

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> findByCategory(Category category) {

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<?> findByColor(Color color) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> findByRating(Rating rating) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> findBySize(Size size) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> findByPrice(Double min, Double max) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> findAny(String param, String sort, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Product> findAll = productRepository.findByNameOrCodeContainingIgnoreCase(param, param, pageable);

        return new ResponseEntity<>(findAll, HttpStatus.OK);
    }
//

	public ProductService(ColorRepository colorRepository, CategoryRepository categoryRepository,
			ProductRepository productRepository, SizeRepository sizeRepository, UserRepository userRepository,
			FileService fileService) {
		super();
		this.colorRepository = colorRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.sizeRepository = sizeRepository;
		this.userRepository = userRepository;
		this.fileService = fileService;
	}

public ProductService() {
	super();
}
    
}
