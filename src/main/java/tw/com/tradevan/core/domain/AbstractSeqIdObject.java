package tw.com.tradevan.core.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Sequence ID
 * @author elliot
 *
 */
@MappedSuperclass
public abstract class AbstractSeqIdObject implements Identifiable<Long> {

	private static final long serialVersionUID = 7933938795919651392L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENTITY_SEQ")
	@Column(name = "OID")
	protected Long oid;
	
	@Override
	public Long getOid() {
		return this.oid;
	}

	@Override
	public void setOid(Long oid) {
		if (oid != null && oid == 0L) {
			this.oid = null;
			return;
		}
		this.oid = oid;
	}

	public boolean isEmptyOid() {
		return oid == null || oid == 0L;
	}
}

