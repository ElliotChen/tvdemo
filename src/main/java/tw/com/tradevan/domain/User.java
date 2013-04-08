package tw.com.tradevan.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import tw.com.tradevan.core.domain.AbstractStrOidAuditable;

@Entity
@Table(name = "T_USER")
public class User extends AbstractStrOidAuditable {
	private static final long serialVersionUID = 6973853293711914826L;

	@Column(name = "NAME", length = 50)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY")
	private Date birthday;

	@Type(type = "yes_no")
	@Column(name = "ADMIN", length=1)
	private Boolean admin;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", length=6)
	private Gender gender;
	public User() {
		super();
	}

	public User(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", birthday=" + birthday + ", admin="
				+ admin + ", gender=" + gender + "]";
	}
	
	
}

