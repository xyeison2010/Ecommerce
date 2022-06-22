package Ecommerce.Utilities;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


public class UploadFileRequest {

    private String username;
    private MultipartFile file;
    
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public UploadFileRequest(String username, MultipartFile file) {
		super();
		this.username = username;
		this.file = file;
	}
	public UploadFileRequest() {
		super();
	}
	@Override
	public String toString() {
		return "UploadFileRequest [username=" + username + ", file=" + file + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UploadFileRequest other = (UploadFileRequest) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
    
    
}
