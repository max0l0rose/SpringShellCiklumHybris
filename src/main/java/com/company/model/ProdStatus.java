package com.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
//@Setter // error
public enum ProdStatus {
	OUT_OF_STOCK(0), IN_STOCK(1), RUNNING_LOW(2);

	final private int value;

	ProdStatus(int value) {
		this.value = value;
	}

	public static ProdStatus fromId(int id) {
		for (ProdStatus type : values()) {
			if (type.getValue() == id) {
				return type;
			}
		}

		throw new IllegalArgumentException();
	}
}
