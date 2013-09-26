package com.vaadin.data;

import com.vaadin.data.Container.Indexed;

public interface ContainerStringIdProvider extends Indexed {

	/**
	 * Returns a unique String id for the given item.
	 * 
	 * @param itemId
	 * @return
	 */
	public String getStringId(Object itemId);
}
