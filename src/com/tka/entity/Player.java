package com.tka.entity;

public class Player {
	private int Jno;
	private String PName;
	private int runs;
	private int wickets;
	private String team;
	public Player() {
		super();
	}
	public Player(int jno, String pName, int runs, int wickets, String team) {
		super();
		Jno = jno;
		PName = pName;
		this.runs = runs;
		this.wickets = wickets;
		this.team = team;
	}
	public int getJno() {
		return Jno;
	}
	public void setJno(int jno) {
		Jno = jno;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "Player [Jno=" + Jno + ", PName=" + PName + ", runs=" + runs + ", wickets=" + wickets + ", team=" + team
				+ "]";
	}
	
	

}
