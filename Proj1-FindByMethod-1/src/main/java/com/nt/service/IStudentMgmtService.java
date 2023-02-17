package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface IStudentMgmtService {
        void pagingStudent(int pageSize);
        List<Student> showDoctorsByExampleData(Student xStudent, boolean asc, String...properties);
        Student showDoctorById(Integer id);
}
