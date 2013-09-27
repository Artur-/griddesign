package org.vaadin.artur.griddesign.client.escalator.event;

import org.vaadin.artur.griddesign.client.escalator.Escalator;

import com.google.gwt.event.shared.EventHandler;

public interface RangeChangeHandler extends EventHandler {
	/**
	 * Called whenever visible rows in the {@link Escalator} viewport change.
	 * 
	 * @param event
	 */
	public void onRangeChange(RangeChangeEvent rangeChangeEvent);
}
