package com.ustglobal.jpawithhibernateapp.onetoone;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="person")
public class Person {

	@Id
	@Column
	private int pid;

	@Column
	private String pname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vid")
	private VoterCard votercard;

}
