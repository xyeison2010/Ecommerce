package Ecommerce.Utilities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class JWTResponse {

    private String token;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date generatedAt;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(Date generatedAt) {
		this.generatedAt = generatedAt;
	}

	public JWTResponse(String token, Date generatedAt) {
		super();
		this.token = token;
		this.generatedAt = generatedAt;
	}

	public JWTResponse() {
		super();
	}

	@Override
	public String toString() {
		return "JWTResponse [token=" + token + ", generatedAt=" + generatedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generatedAt == null) ? 0 : generatedAt.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		JWTResponse other = (JWTResponse) obj;
		if (generatedAt == null) {
			if (other.generatedAt != null)
				return false;
		} else if (!generatedAt.equals(other.generatedAt))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}
    
    
}
