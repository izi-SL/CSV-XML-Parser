package com.isuru.parserfactory;

public interface Parser<T> {

	T getFirstElement();

	T getLastElement();

	T getElementByIndex(int index);

	T getElementByName(String name);

}
