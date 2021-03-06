package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entities.Dept;
import repo.DeptRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages="repo")
@EntityScan(basePackages="entities")
public class JPAApplication {

	@Autowired
	public DeptRepository repo;	

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(JPAApplication.class,args);
	}
	
	
	@Bean
	public String method1(){
		
		for (int i=10;i<100;i+=10){
			
			Dept d = new Dept();
			d.setDeptno(i);
			d.setDname("NM "+i);
			if(i%20==0)
			d.setLoc("Hyd");
			else 
				d.setLoc("Blr");
			repo.save(d);		
		}
	
		Dept d = new Dept();
		d.setDeptno(10);d.setDname("HR");d.setLoc("pnq");
		repo.save(d);
		repo.deleteById(20);
		repo.findAll().forEach(System.out::println);
		
		
		return "Success";
	}
	
	@Bean
	public String method2(){
		
		Dept d = new Dept();                         
		d.setLoc("Hyd");     
		d.setDname("NM 60");
		Example<Dept> example = Example.of(d);
		List<Dept> results = repo.findAll(example);
		results.forEach(System.out::println);
		
		
		/*System.out.println("Inside method 2");
		repo.findAllByLoc("Hyd").forEach(System.out::println);;*/
		return "Success";
	}
	

}
