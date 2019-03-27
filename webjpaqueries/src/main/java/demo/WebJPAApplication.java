package demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import entities.Emp;
import repo.EmpRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages="repo")
@EntityScan(basePackages="entities")
public class WebJPAApplication {

	@Autowired
	public EmpRepository repo;	

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(WebJPAApplication.class,args);
	}
	
	@Bean
	public String method1(){
		
	/*	for (int i=10;i<100;i+=10){
			
			Emp e = new Emp();
			e.setEmpno(i);
			e.setEname("EMP-"+i);
			if(i%20==0)
				e.setProject("UBS");
			else 
				e.setProject("MSCI");
			e.setSalary(i*10000);
			repo.save(e);		
		}*/
	
//		Dept d = new Dept();
//		d.setDeptno(10);d.setDname("HR");d.setLoc("pnq");
//		repo.save(d);
//		repo.deleteById(20);
//		repo.findAll().forEach(System.out::println);
		
		
		List<String > names = Arrays.asList("navneet","suresh","mohin","jankee","vasudev","jyotsna");
		List<String > project = Arrays.asList("project1","project2");
		
		for (int i=1;i<10;i+=1){
			Emp e = new Emp();
			e.setEname(names.get(i % names.size()));
			e.setProject(project.get(i % project.size()));
			e.setSalary(i*100);
			
			repo.save(e);
		
		}
		
		
		
		
		return "Success";
	}
	
	
}
