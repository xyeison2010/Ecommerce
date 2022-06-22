package Ecommerce.Security;

import org.springframework.http.ResponseEntity;

import Ecommerce.Entities.User;
import Ecommerce.Utilities.SignInRequest;
import Ecommerce.Utilities.SignUpRequest;


public interface AuthenticationService {
    User save(SignUpRequest request);

    User signUp(SignUpRequest request);

    ResponseEntity<?> signIn(SignInRequest request);
}
