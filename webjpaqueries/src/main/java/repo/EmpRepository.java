package repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {

	public List<Emp> findByProject(String project);
	public List<Emp> findBySalaryBetween(double min, double max);
	public List<Emp> findByProjectAndEname(String project,String ename);
	public List<Emp> findByProjectOrEname(String project,String ename);
	
	
	@Query(value="select e from Emp e where e.project = :test")
	public List<Emp> findByProj(@Param("test") String project);

}
