package org.rakesh.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
	
	@Query(value="select * from public.employee where salary = (select max(salary) from public.employee) limit 1", nativeQuery=true)
	public  Employee getMaxEmployee();
	
	@Query(value="select * from public.employee where empid=:ID", nativeQuery=true)
	public  Employee getSpEmployee(@Param("ID") Integer ID );
	
	@Query(value = "select distinct empid from public.employee",nativeQuery = true)
	public List<Integer> searchEmployee();


	//public List<Object> checkObject();
	@Query(value = "select * from public.employee",nativeQuery = true)
	public List<Object> checkObject();
	
	
}
