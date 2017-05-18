package com.productStore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 8215940655966357715L;

	private Long id;
	private String name;
	private Set<Users> users;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "roles")
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Roles(){
		super();
	}
	public Roles(Long id,String name){
		this.id=id;
		this.name=name;
	}
}

