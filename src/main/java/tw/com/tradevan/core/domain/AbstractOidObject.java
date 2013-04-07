package tw.com.tradevan.core.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.StringUtils;
/**
 * Assigned Oid
 * @author elliot
 *
 */
@MappedSuperclass
public abstract class AbstractOidObject implements Identifiable<String> {

	private static final long serialVersionUID = -1702181490872061369L;

	@Id
	@Column(name = "OID", length = 32)
	protected String oid;
	
	@Override
	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		if (StringUtils.isEmpty(oid)) {
			this.oid = null;
			return;
		}
		
		this.oid = oid;
	}
}
