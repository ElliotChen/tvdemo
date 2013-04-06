package tw.com.tradevan.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import tw.com.tradevan.core.domain.Identifiable;

@Entity
@Table(name = "T_BOOK")
public class Book implements Identifiable<BookPK> {

	private static final long serialVersionUID = -882132308898534333L;
	@EmbeddedId
	private BookPK oid;
	@Column(name = "NOTE", length = 50)
	private String note;

	@Override
	public BookPK getOid() {
		return oid;
	}

	@Override
	public void setOid(BookPK oid) {
		this.oid = oid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public boolean isEmptyOid() {
		boolean result = false;
		if (oid == null) {
			result = true;
		} else if (StringUtils.isEmpty(oid.getName()) || oid.getYear() == null) {
			result = true;
		}
		System.out.println(result);
		return result;
	}

	@Override
	public String toString() {
		return "Book [oid=" + oid + ", note=" + note + "]";
	}
	
}
