package com.example.ssc.meet;


public class Meet {
	private Integer id;
	private String meetTime;
	private String meet_academy;
	private Integer meet_people;
	private String meet_grade;

	public Meet(Integer id, String meetTime, String meet_academy, Integer meet_people, String meet_grade) {
		super();
		this.id = id;
		this.meetTime = meetTime;
		this.meet_academy = meet_academy;
		this.meet_people = meet_people;
		this.meet_grade = meet_grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeetTime() {
		return meetTime;
	}

	public void setMeetTime(String meetTime) {
		this.meetTime = meetTime;
	}

	public String getMeet_academy() {
		return meet_academy;
	}

	public void setMeet_academy(String meet_academy) {
		this.meet_academy = meet_academy;
	}

	public Integer getMeet_people() {
		return meet_people;
	}

	public void setMeet_people(Integer meet_people) {
		this.meet_people = meet_people;
	}

	public String getMeet_grade() {
		return meet_grade;
	}

	public void setMeet_grade(String meet_grade) {
		this.meet_grade = meet_grade;
	}


}
