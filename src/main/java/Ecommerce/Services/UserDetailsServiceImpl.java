package Ecommerce.Services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Ecommerce.Entities.User;
import Ecommerce.Exceptions.UserNotFoundException;
import Ecommerce.Repositories.UserRepository;
import Ecommerce.Utilities.MyUserDetailsImpl;

@Service
//@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException(email);
        }
        return new MyUserDetailsImpl(user);

    }
//
	public UserDetailsServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	public UserDetailsServiceImpl() {
		super();
	}

}
