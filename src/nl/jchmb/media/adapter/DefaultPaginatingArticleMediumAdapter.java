package nl.jchmb.media.adapter;

import nl.jchmb.media.article.Article;

public abstract class DefaultPaginatingArticleMediumAdapter 
			extends DefaultArticleMediumAdapter
			implements PaginatingMediumAdapter<Article> {
	private int page;
	
	@Override
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public int getPage() {
		return page;
	}
}
