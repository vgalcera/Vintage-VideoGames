package com.vgalcera.examples.backend.vintagevideogames.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Game
 *
 * @author Vanessa
 */
@Entity
public class Game implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_game")
	private int id;
	
	@NotNull
	@Size(min = 5, max = 20, message = "El nombre debe contener entre 5 y 20 caracteres")
	private String name;
	
	@NotNull
	@Size(min = 5, max = 1000, message = "La descripción debe contener entre 5 y 1000 caracteres")
	private String description;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	@DecimalMax(value = "10.0", message = "La puntuacion maxima es 10")
	@DecimalMin(value = "0.0", message = "La puntuacion minima es 0")
	@NotNull
	private float score;
	
	@ManyToMany
	@NotNull
	private List<Platform> platform;   
	
	private static final long serialVersionUID = 1L;

	public Game() {
		super();
	}   
		
	/* GETTERS AND SETTERS */

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	  
	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}   
  
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Platform> getPlatform() {
		return platform;
	}
	public void setPlatform(List<Platform> platform) {
		this.platform = platform;
	}
	
	
	/* toString(), equals() and hashCode() */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		Game other = (Game) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Game [name=" + name + ", date=" + date + "]";
	}
	
	
   
}
