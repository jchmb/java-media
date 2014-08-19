package nl.jchmb.media.adapter;

import nl.jchmb.media.entity.Entity;

public interface PaginatingAggregateMediumAdapter<T extends Entity> 
		extends AggregateMediumAdapter<T> {
	public void setPaginatingMediumAdapterClass(Class<PaginatingMediumAdapter<T>> paginatingMediumAdapterClass);
	public void setRange(int pageFrom, int pageTo);
	public void setRange(int pageTo);
}
