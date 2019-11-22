package com.ustglobal.jpawithhibernateapp.manytomany;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="Course")
public class Course {
	
	@Id
	@Column
	private int cid;
	
	@Column
	private String cname;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "Course")
	private List<Student> Student;

}