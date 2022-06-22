package Ecommerce.DTO;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import Ecommerce.Entities.Role;
import Ecommerce.Entities.User;
import Ecommerce.Repositories.RoleRepository;
import Ecommerce.Utilities.SignUpRequest;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public abstract class SignUpRequestMapper {

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Mapping(target = "password", ignore = true)
    abstract SignUpRequest userToSignUpRequest(User user);

    @Mapping(target = "roles", expression = "java(this.getRoles())")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(signUpRequest.getPassword()))")
    public abstract User signUpRequestToUser(SignUpRequest signUpRequest);

    protected List<Role> getRoles() {
        return List.of(roleRepository.findByRole("USER"));
    }
}
