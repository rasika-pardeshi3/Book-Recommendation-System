package org.book.recommend.model;

public class AuthorModel {
	private int id;
	private String name;

	public AuthorModel() {
	}

	public AuthorModel(int id, String name, int exp, String qual) {
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.qual = qual;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	private String qual;
	private int exp;

}
