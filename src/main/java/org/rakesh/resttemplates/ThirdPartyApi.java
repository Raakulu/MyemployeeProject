package org.rakesh.resttemplates;

import java.util.ArrayList;
import org.rakesh.Employee.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ThirdPartyApi {
	
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value = "/getCount", method = RequestMethod.GET)
	public String getNumberOfEmployees(){
		
		HttpHeaders headers = new HttpHeaders();
		ArrayList<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.APPLICATION_JSON);
		headers.setAccept(list);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url = "http://localhost:8080/Employees/";
		ResponseEntity<ArrayList> response =  restTemplate.exchange(url, HttpMethod.GET,entity,ArrayList.class) ;
		ArrayList<Employee> employees = response.getBody();
		int count = employees.size();
		return "The number of employees are "+ count;
		
	}


}
