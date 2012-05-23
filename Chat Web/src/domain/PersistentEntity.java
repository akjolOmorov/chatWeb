package domain;

import java.io.Serializable;

/***
 * 
 * @author A.Omorov
 *
 * @param <PK>
 */

public interface PersistentEntity<PK extends Serializable> extends Serializable {
	
	PK getId();
	void setId(PK pk);

}
