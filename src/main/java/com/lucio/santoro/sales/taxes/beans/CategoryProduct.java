package com.lucio.santoro.sales.taxes.beans;

public class CategoryProduct implements Category {
	private String type;
	private boolean exception;

	public CategoryProduct() {

	}

	public CategoryProduct(String type, boolean exception) {
		this.type = type;
		this.exception = exception;

	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		else if (obj == this) {
			return true;

		}

		CategoryProduct category = (CategoryProduct) obj;

		if (type.equals(category.type) && exception == category.exception)
			return true;

		return false;
	}

	@Override
	public boolean isExcemption() {
		return exception;
	}

	@Override
	public String type() {
		return type;
	}

}
