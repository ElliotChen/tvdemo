package tw.com.tradevan.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tw.com.tradevan.core.domain.AbstractStrOidAuditable;

@Entity
@Table(name = "T_USER")
public class User extends AbstractStrOidAuditable {
	private static final long serialVersionUID = 6973853293711914826L;

	@Column(name = "NAME", length = 50)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DAY")
	private Date birthDay;

	public User() {
		super();
	}

	public User(String name, Date birthDay) {
		this.name = name;
		this.birthDay = birthDay;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}

