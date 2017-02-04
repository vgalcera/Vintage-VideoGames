package com.vgalcera.examples.backend.vintagevideogames.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Platform
 *
 * @author Vanessa
 * 
 */
@Entity
public class Platform implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_platform")
	private int id;
	
	@NotNull
	@Size(min = 5, max = 20, message = "El nombre debe contener entre 5 y 20 caracteres")
	private String name;
	
	@NotNull
	@Size(min = 5, max = 1000, message = "La descripción debe contener entre 5 y 1000 caracteres")
	private String description;

	private static final long serialVersionUID = 1L;
	
	public Platform() {
		super();
	}   
	
	
	/* GETTERS AND SETTERS */

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	/* toString(), equals() and hashCode() */
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Platform other = (Platform) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Platform [name=" + name + "]";
	}

}
