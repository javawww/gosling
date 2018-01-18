package com.gosling.core;

import java.util.List;

public class GridData {
	@SuppressWarnings("rawtypes")
	private List data;

	private int recordsTotal;

	private int page;

	private int xxUserId;

	/**
	 * @return the data
	 */
	public List getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List data) {
		this.data = data;
	}

	/**
	 * @return the recordsTotal
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordsTotal the recordsTotal to set
	 */
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the xxUserId
	 */
	public int getXxUserId() {
		return xxUserId;
	}

	/**
	 * @param xxUserId the xxUserId to set
	 */
	public void setXxUserId(int xxUserId) {
		this.xxUserId = xxUserId;
	}
	
	
	
}
