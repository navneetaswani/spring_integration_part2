package demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Emp;
import repo.EmpRepository;

@RestController
@RequestMapping(value="/page")
public class Pagging {

	@Autowired
	private EmpRepository repo;
	

	public Pagging() {
		System.out.println("in paging constuctor");
		
	
	}
	
	@GetMapping(value="/{pageno}")
	public List<Emp> list(@PathVariable(name="pageno") int pageno){
		System.out.println("in list..." + pageno);	
	//pagereq = PageRequest.of(pageno, 5);	
	if (pageno ==1 )
		return 	repo.findAll(PageRequest.of(0, 3).first()).get().collect(Collectors.toList());
	else
		return 	repo.findAll(PageRequest.of(pageno-2, 3).next()).get().collect(Collectors.toList());
	}
	
}
