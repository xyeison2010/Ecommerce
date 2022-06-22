package Ecommerce.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import Ecommerce.Controllers.ColorsController;
import Ecommerce.DTO.SignUpRequestMapper;
import Ecommerce.Entities.User;
import Ecommerce.Exceptions.UserExistException;
import Ecommerce.Repositories.UserRepository;
import Ecommerce.Security.AuthenticationService;
import Ecommerce.Utilities.JWTResponse;
import Ecommerce.Utilities.JwtUtils;
import Ecommerce.Utilities.SignInRequest;
import Ecommerce.Utilities.SignUpRequest;

import java.util.Date;
import java.util.Optional;

@Service
//@AllArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
	
	//log
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	

    private  UserRepository userRepository;
    
    private  AuthenticationManager authenticationManager;
    private  SignUpRequestMapper signUpRequestMapper;
    private  JwtUtils jwtUtils;


    @Override
    public User signUp(SignUpRequest request) {
        log.debug("SERVICE::REQUEST TO SIGNUP {}", request);
        if (userRepository.existByEmail(request.getEmail())) {
            throw new UserExistException("E-mail already exist");
        }
        return save(request);
    }

    @Override
    public ResponseEntity<?> signIn(SignInRequest request) {
        log.debug("SERVICE::REQUEST TO SIGNING {}", request);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(new JWTResponse(jwt, new Date()));
    }

    @Override
    public User save(SignUpRequest request) {
        return Optional.of(request)
                .map(signUpRequestMapper::signUpRequestToUser)
                .map(userRepository::save)
                .orElse(null);
    }
//
	public AuthenticationServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager,
			SignUpRequestMapper signUpRequestMapper, JwtUtils jwtUtils) {
		super();
		this.userRepository = userRepository;
		this.authenticationManager = authenticationManager;
		this.signUpRequestMapper = signUpRequestMapper;
		this.jwtUtils = jwtUtils;
	}

	public AuthenticationServiceImpl() {
		super();
	}
    
    
}
