package br.gov.fjrj.models;

@javax.persistence.Entity
public class Product extends Entity {

	private String name;
	private Double value;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

}
