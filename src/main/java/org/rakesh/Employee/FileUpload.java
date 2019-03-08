package org.rakesh.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class FileUpload {



	@Id
	private byte[] file_upload;
	
	public FileUpload(byte[] file_upload) {
		super();
		this.file_upload = file_upload;
	}

	public byte[] getFile_upload() {
		return file_upload;
	}

	public void setFile_upload(byte[] file_upload) {
		this.file_upload = file_upload;
	}

	


	
	
}
