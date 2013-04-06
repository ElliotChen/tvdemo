package tw.com.tradevan.domain;

import java.io.Serializable;

public class BookPK implements Serializable {
	private static final long serialVersionUID = -2179748380685341249L;
	private String name;
	private Integer year;
	
	public BookPK() {
		super();
	}
	
	public BookPK(String name, Integer year) {
		super();
		this.name = name;
		this.year = year;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
}
