
package Ecommerce.Controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Entities.User;
import Ecommerce.Services.AuthenticationServiceImpl;
import Ecommerce.Utilities.SignInRequest;
import Ecommerce.Utilities.SignUpRequest;


@RestController
//@AllArgsConstructor
public class AuthRestController {

    private Logger logger = LoggerFactory.getLogger(AuthRestController.class);
    private AuthenticationServiceImpl authenticationServiceImpl;

    @PostMapping(value = "/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest request) {
        logger.debug("RESOURCE::REQUEST TO SIGNIN {}", request);
        return authenticationServiceImpl.signIn(request);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
        logger.debug("RESOURCE::REQUEST TO SIGNUP {}", request);
        User result = authenticationServiceImpl.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

	public AuthRestController(Logger logger, AuthenticationServiceImpl authenticationServiceImpl) {
		super();
		this.logger = logger;
		this.authenticationServiceImpl = authenticationServiceImpl;
	}

	public AuthRestController() {
		super();
	}
    
    
}
