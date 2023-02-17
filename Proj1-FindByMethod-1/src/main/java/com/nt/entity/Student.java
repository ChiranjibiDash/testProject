package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="student_info")
@Data
public class Student {
    @Id
    @SequenceGenerator(name = "gen2", sequenceName = "std_seq", initialValue = 201, allocationSize = 1)
    @GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
	private Integer sno;
	@Column(name="s_name")
	private String sname;
	@Column(name="s_addrs")
	private String saddrs;
	private String course;
}
