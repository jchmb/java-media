package nl.jchmb.media.adapter;

import nl.jchmb.media.entity.Entity;

public class SimplePaginatingAggregateMediumAdapter<T extends Entity> 
		extends SimpleAggregateMediumAdapter<T>
		implements PaginatingAggregateMediumAdapter<T> {
	private Class<PaginatingMediumAdapter<T>> paginatingMediumAdapterClass;
	private int pageFrom, pageTo;
	
	public SimplePaginatingAggregateMediumAdapter() {
		super();
	}

	@Override
	public void setPaginatingMediumAdapterClass(
			Class<PaginatingMediumAdapter<T>> paginatingMediumAdapterClass) {
		this.paginatingMediumAdapterClass = paginatingMediumAdapterClass;
		clear();
		update();
	}

	@Override
	public void setRange(int pageFrom, int pageTo) {
		this.pageFrom = pageFrom;
		this.pageTo = pageTo;
		clear();
		update();
	}

	@Override
	public void setRange(int pageTo) {
		setRange(1, pageTo);
	}
	
	private void update() {
		PaginatingMediumAdapter<T> mediumAdapter;
		
		for (int i = pageFrom; i <= pageTo; i++) {
			try {
				mediumAdapter = paginatingMediumAdapterClass.newInstance();
				mediumAdapter.setPage(i);
				addMediumAdapter(mediumAdapter);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
