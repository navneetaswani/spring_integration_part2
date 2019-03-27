package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {

	public List<Dept> findAllByLoc(String string);
	
	//public List<Dept> findAllDepts();

}
