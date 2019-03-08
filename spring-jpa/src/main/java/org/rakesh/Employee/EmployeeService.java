package org.rakesh.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;*/
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class EmployeeService {


	
	@Autowired
	EmployeeDao empDao;
	FileDao filedao;
	
	//private DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres","postgres","postgresql");
	
	//private JdbcTemplate temp = new JdbcTemplate(ds);
	

	
	
	


	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		Iterable<Employee> iterator = empDao.findAll();
		for(Employee e:iterator) {
			System.out.println(e);
			list.add(e);
		}
		return list;
	}
	
	public Employee getEmployee(int id) {
		//Employee e1 = new Employee();
		Employee e2 = new Employee();
		//e1=empDao.getMaxEmployee();
		e2=empDao.getSpEmployee(id);
		return e2;
	}
	

	public void addEmployee(Employee emp) {
		empDao.save(emp);
	}
	
	public void updateEmployee(Employee emp, int id) {
		empDao.save(emp);
	}
	
	public void deleteEmployee(int id) {
		empDao.deleteById(id);
		}

	public boolean searchEmployee(int id) {
		List<Integer> idList = new ArrayList<Integer>();
		idList = empDao.searchEmployee();
		return idList.contains(id);
		}

	public Object[] checkingObject() {
		List<Object> obj = empDao.checkObject();
		Object[] ao = null;
		Iterator itr = obj.iterator();
		while(itr.hasNext()) {
			ao = (Object[])itr.next();
			
		}
		return ao;
		
		
		
	}

	}
	

