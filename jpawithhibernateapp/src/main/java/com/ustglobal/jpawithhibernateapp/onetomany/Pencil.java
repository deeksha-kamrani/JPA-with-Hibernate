package com.ustglobal.jpawithhibernateapp.onetomany;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="pencil")
public class Pencil {
    @Id
    @Column
	private int pid;
	@Column
	private String color;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bid", nullable = false)
	
	private PencilBox pencilBox;

}
