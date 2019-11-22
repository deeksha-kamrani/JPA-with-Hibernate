package com.ustglobal.jpawithhibernateapp.onetoone;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString.Exclude;


@Data
@Entity
@Table(name="votercard")
public class VoterCard {
	
	@Id
	@Column
	private int vid;
	
	@Column
	private String vname;
	
	@Exclude
	@OneToOne(mappedBy = "votercard")
	private Person person;	
}