package com.ustglobal.jpawithhibernateapp.manytomany;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column
	private int sid;
	@Column
	private String sname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name= "Student_Course", joinColumns = @JoinColumn(name="sid"), 
	inverseJoinColumns = @JoinColumn(name="cid"))

	private List<Course> Course;
}