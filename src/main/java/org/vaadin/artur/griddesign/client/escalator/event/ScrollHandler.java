package org.vaadin.artur.griddesign.client.escalator.event;

import org.vaadin.artur.griddesign.client.escalator.Escalator;

import com.google.gwt.event.shared.EventHandler;

public interface ScrollHandler extends EventHandler {
	/**
	 * Called whenever the {@link Escalator} is scrolled to a new position.
	 * 
	 * @param event
	 */
	public void onScroll(ScrollEvent event);
}
