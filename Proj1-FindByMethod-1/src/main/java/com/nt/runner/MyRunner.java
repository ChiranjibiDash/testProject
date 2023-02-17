package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IStudentRepo;
import com.nt.view.ResultView2;
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private IStudentRepo sRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 * sRepo.findBysNameEquals("butu").forEach(System.out::println);
		 * sRepo.findBysNameIs("titu").forEach(System.out::println);
		 */
	    // sRepo.findBysNameAndSno("titu", 23).forEach(System.out::println);
	    //sRepo.findBysNameOrSno("titu", 22).forEach(System.out::println);
	    // sRepo.findBySnoBetween(20, 23).forEach(System.out::println);
		//sRepo.findBySnoLessThan(23).forEach(System.out::println);
		//sRepo.findBysNameLike("b"+"%").forEach(System.out::println);
		//sRepo.findBysNameStartingWith("sa").forEach(System.out::println);
		//sRepo.findBysNameOrderBySnoDesc("butu").forEach(System.out::println);
		
		 // sRepo.findBySnoGreaterThanEqualAndSnoLessThanEqual(21,24).forEach(System.out::println);
		 //sRepo.findBySnoGreaterThanOrSnoLessThan(23, 22).forEach(System.out::println);
		 List<ResultView2> list  = sRepo.findByCourseIn(List.of("java"),ResultView2.class);
		 list.forEach(p->System.out.println(p.getSno()+"..........."+p.getCourse()+"......"+p.getSaddrs()));
	}

}
