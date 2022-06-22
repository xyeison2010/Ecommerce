
package Ecommerce.Controllers;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Services.FileService;


@RestController
@RequestMapping("/files")
//@AllArgsConstructor
public class FilesController {
    private  Logger logger = LoggerFactory.getLogger(AuthRestController.class);
    private  FileService fileService;

    @GetMapping(value = "/{filename}")
    public ResponseEntity<?> list(@PathVariable(name = "filename") String filename, HttpServletRequest request) {
        logger.debug("RESOURCE::REQUEST TO GET FILE BY NAME {}", filename);
        return fileService.getFile(filename, request);
    }
//
	public FilesController(Logger logger, FileService fileService) {
		super();
		this.logger = logger;
		this.fileService = fileService;
	}

	public FilesController() {
		super();
	}

    
}
