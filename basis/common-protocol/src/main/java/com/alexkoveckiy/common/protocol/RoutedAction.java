package com.alexkoveckiy.common.protocol;

import java.io.Serializable;

public class RoutedAction<T extends Serializable> extends Action<T> {
	private static final long serialVersionUID = -318012176965757271L;

	public RoutedAction() {
	}

	public RoutedAction(ActionHeader header, T data) {
		super(header, data);
	}
}
