package com.example.jpa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Image_table")

public class ImageModel  {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public ImageModel() {

		super();

	}
	public ImageModel(String name, String type, byte[] picByte) {

		this.name = name;

		this.type = type;

		this.picByte = picByte;

	}
	@Id

	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "Name")

	private String name;

	@Column(name = "Pic_type")

	private String type;

	// image bytes can have large lengths so we specify a value

	// which is more than the default length for picByte column

	@Column(name = "Pic_byte", length = 1000)

	private byte[] picByte;

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getType() {

		return type;

	}

	public void setType(String type) {

		this.type = type;

	}

	public byte[] getPicByte() {

		return picByte;

	}

	public void setPicByte(byte[] picByte) {

		this.picByte = picByte;

	}

}
