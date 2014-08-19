package nl.jchmb.media.adapter;

import nl.jchmb.media.entity.Entity;

public interface PaginatingMediumAdapter<T extends Entity> extends MediumAdapter<T> {
	public void setPage(int page);
	public int getPage();
}
