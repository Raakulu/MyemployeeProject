package org.rakesh.Employee;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.rakesh.exception.IdAlreadyExistsException;
import org.rakesh.exception.IdNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService empService;

	
	
	
	
	@RequestMapping("/Employees")
	public ResponseEntity<?> getAllEmployees(){
		logger.info("In the get all method");
		return new ResponseEntity<Object>(empService.getAllEmployees(),HttpStatus.OK);
	}
	
	@RequestMapping("/Employees/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		logger.info("In id method");
		Boolean flag = empService.searchEmployee(id);
		if(flag)
		return ResponseEntity.ok(empService.getEmployee(id));
		else
			throw new IdNotFoundException(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value="/Employees" )
	public ResponseEntity<HttpStatus> addEmployee(@RequestBody Employee emp) {
		logger.warn("in adding employee method");
		Boolean flag = empService.searchEmployee(emp.getEmpid());
		if(flag)
			throw new IdAlreadyExistsException(emp.getEmpid());
		else
				{
			empService.addEmployee(emp);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
				}
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Employees/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp,@PathVariable int id) {
		Boolean flag = empService.searchEmployee(id);
		if(flag) {
		empService.updateEmployee(emp, id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else
			throw new IdNotFoundException(id);
		
		
		
	}
	
	@RequestMapping(method= RequestMethod.DELETE,value = "/Employees/{id}")
	public  ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		logger.warn("are you sure to delete");
		if(empService.searchEmployee(id))
			{empService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
		else
			throw new IdNotFoundException(id);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/download")
	public ResponseEntity<Object> downloadFile() throws FileNotFoundException{
		
		String filename = "D:\\GEGDC\\RN551626\\Downloads\\app sec newdumps\\app sec newdumps\\1.png";
		File file = new File(filename);
		FileInputStream fin = new FileInputStream(file);
		InputStreamResource resource = new InputStreamResource(fin);
		
		HttpHeaders headers = new HttpHeaders();
	      headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	      headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	      headers.add("Pragma", "no-cache");
	      headers.add("Expires", "0");
	      
	      ResponseEntity<Object> 
	      responseEntity = ResponseEntity.ok().headers(headers).contentLength(
	         file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
	      
	      return responseEntity;
		
		
	}
	

	
	
/*	@RequestMapping(value = "/upload",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("D:\\GEGDC\\RN551626\\Downloads\\upload\\"+ file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		byte a[] = file.getBytes();
		for(byte c :a) {
			System.out.print((char)c);
		}
		
		FileUpload f = new FileUpload(a);
		System.out.println(f.getFile_upload().length);
		
		empService.saveFile(new FileUpload(a));
		
		
		return "success";
		
	}*/
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/check")
	public String Checking() {
		Object[] emp = empService.checkingObject();
		return (String)emp[1];
	}
		
}
