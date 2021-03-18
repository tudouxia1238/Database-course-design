package com.example.ssc.visitor;

public class Visitor {
	private Integer id;
	private String  grade;
	private String  telephone;
	private String xueyuan;
	private Integer number;

	public Visitor(Integer id, String grade, String telephone, String xueyuan, Integer number) {
		super();
		this.id = id;
		this.grade = grade;
		this.telephone = telephone;
		this.xueyuan = xueyuan;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getXueyuan() {
		return xueyuan;
	}

	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
