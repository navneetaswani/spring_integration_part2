package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Emp;
import repo.EmpRepository;

@RestController
@RequestMapping(value="/emp")
public class MyQueries {
	
	@Autowired
	private EmpRepository repo; 
	
	@RequestMapping(value="/{project}")
	public List<Emp> byproject(@PathVariable(name="project") String project){
		return repo.findByProject(project);
	}

	
	@RequestMapping(value="/{project}/{ename}")
	public List<Emp> byprojectAndEname(@PathVariable(name="project") String project,@PathVariable(name="ename") String ename){
		return repo.findByProjectAndEname(project, ename);
	}
	
	
	@RequestMapping(value="normal/{project}")
	public List<Emp> byProj(@PathVariable(name="project") String project){
		return repo.findByProj(project);
	}
	
}
