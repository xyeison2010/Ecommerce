package Ecommerce.Utilities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.*;


@Builder
public class SignUpRequest {
    @Email(message = "error.email.not-valid")
    private String email;
    @NotBlank(message = "error.password.required")
    private String password;
    @NotBlank(message = "error.firstname.required")
    private String firstname;
    @NotBlank(message = "error.lastname.required")
    private String lastname;
    
    
    
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public SignUpRequest(@Email(message = "error.email.not-valid") String email,
			@NotBlank(message = "error.password.required") String password,
			@NotBlank(message = "error.firstname.required") String firstname,
			@NotBlank(message = "error.lastname.required") String lastname) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public SignUpRequest() {
		super();
	}
	@Override
	public String toString() {
		return "SignUpRequest [email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUpRequest other = (SignUpRequest) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
    
    
}
