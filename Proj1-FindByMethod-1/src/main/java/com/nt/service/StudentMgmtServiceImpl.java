package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.IStudentRepo;

@Service("sService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private IStudentRepo sRepo;
	@Override
	public void pagingStudent(int pageSize) {
		long count = sRepo.count();
		long pageCount = count/pageSize;
		pageCount = count%pageSize==0?pageCount:++pageCount;
		
		for(int i=0;i<pageCount;i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Student> page = sRepo.findAll(pageable);
			System.out.println("Page :: "+(page.getNumber()+1)+" record of "+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("=========================================================");
		}
	}
	@Override
	public List<Student> showDoctorsByExampleData(Student xStudent, boolean asc, String... properties) {
		Example<Student> example = Example.of(xStudent);
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		List<Student> list = sRepo.findAll(example, sort);
		return list;
	}
	@Override
	public Student showDoctorById(Integer id) {
		Student student = sRepo.getReferenceById(id);
		return student;
	}
	

}
