package domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/****
 * 
 * @author A.Omorov
 *
 * @param <S>
 */

@MappedSuperclass
public abstract class AbstractEntity<S extends Serializable> implements PersistentEntity<S> {

	protected S id;
	private static final long serialVersionUID = 4635290765498914296L;

	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public S getId() {
		return id;
	}
	
	public void setId(S id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		AbstractEntity<S> other = (AbstractEntity<S>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		return this.getClass() + " [id=" + id + "]";
	}
		
}
