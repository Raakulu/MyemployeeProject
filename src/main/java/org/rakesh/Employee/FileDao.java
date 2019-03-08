package org.rakesh.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FileDao extends CrudRepository<FileUpload, byte[]> {

}
