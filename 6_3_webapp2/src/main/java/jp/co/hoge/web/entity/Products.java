package jp.co.hoge.web.entity;

public class Products {

	private int id;
	private String name;
	private int units;
	
	public Products() {
		
	}
	
	public Products(int id, String name, int units) {
		this.id=id;
		this.name=name;
		this.units=units;
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

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public String toString() {
	    return "Products{" +
	           "id=" + id +
	           ", name='" + name + '\'' +
	           ", units=" + units +
	           '}';
	}

}
