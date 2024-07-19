package com.watches.entities;

import java.io.Serializable;
import java.util.List;

public class WatchPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<WatchSpecsWithSale> watches;
	private int totalPages;
	private int pageSize;
	private int currentPage;
	
	public WatchPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WatchPage(List<WatchSpecsWithSale> watches, int totalPages, int pageSize, int currentPage) {
		super();
		this.watches = watches;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}
	public List<WatchSpecsWithSale> getWatches() {
		return watches;
	}
	public void setWatches(List<WatchSpecsWithSale> watches) {
		this.watches = watches;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
}
