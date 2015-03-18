package com.jmzc.fonetic.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;


@Entity
public class Item implements Serializable 
{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
private Integer id;

@Column(nullable = false)
@NaturalId
private String name;

@Column(nullable = false)
private String type;

public Integer getId() 
{
	return id;
}

public void setId(Integer id) 
{
	this.id = id;
}

public String getName()
{
	return name;
}

public void setName(String name) 
{
	this.name = name;
}

public String getType() 
{
	return type;
}

public void setType(String type) 
{
	this.type = type;
}





}

