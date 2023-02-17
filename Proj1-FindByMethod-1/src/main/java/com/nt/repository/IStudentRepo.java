package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Student;
import com.nt.view.IView;

public interface IStudentRepo extends JpaRepository<Student, Integer>{
	public List<Student> findBysNameEquals(String name);
	public List<Student> findBysNameIs(String name);
	public List<Student> findBysNameAndSno(String name, int id);
	public List<Student> findBysNameOrSno(String name, int id);
	public List<Student> findBySnoBetween(int sno1, int sno2);
	public List<Student> findBySnoLessThan(int sno);
	public List<Student> findBysNameLike(String name);
	public List<Student> findBysNameStartingWith(String name);
	public List<Student> findBysNameOrderBySnoDesc(String name);
	public List<Student> findBySnoGreaterThanEqualAndSnoLessThanEqual(int start, int end);
	public List<Student> findBySnoGreaterThanOrSnoLessThan(int start, int end);
	public <T extends IView> List<T> findByCourseIn(List<String> l, Class<T> clazz);
}
