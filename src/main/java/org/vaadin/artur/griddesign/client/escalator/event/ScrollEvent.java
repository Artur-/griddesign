package org.vaadin.artur.griddesign.client.escalator.event;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.GwtEvent;

public class ScrollEvent extends GwtEvent<ScrollHandler> {

	int estimatedFirstVisibleRow;
	int estimatedLastVisibleRow;
	/**
	 * Event type for scroll events. Represents the meta-data associated with
	 * this event.
	 */
	private static final Type<ScrollHandler> TYPE = new Type<ScrollHandler>();

	/**
	 * Gets the event type associated with scroll events.
	 * 
	 * @return the handler type
	 */
	public static Type<ScrollHandler> getType() {
		return TYPE;
	}

	/**
	 * Protected constructor, use
	 * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
	 * to fire scroll events.
	 */
	protected ScrollEvent() {
	}

	/**
	 * @return the estimatedFirstVisibleRow
	 */
	public int getEstimatedFirstVisibleRow() {
		return estimatedFirstVisibleRow;
	}

	/**
	 * @param estimatedFirstVisibleRow
	 *            the estimatedFirstVisibleRow to set
	 */
	public void setEstimatedFirstVisibleRow(int estimatedFirstVisibleRow) {
		this.estimatedFirstVisibleRow = estimatedFirstVisibleRow;
	}

	/**
	 * @return the estimatedLastVisibleRow
	 */
	public int getEstimatedLastVisibleRow() {
		return estimatedLastVisibleRow;
	}

	/**
	 * @param estimatedLastVisibleRow
	 *            the estimatedLastVisibleRow to set
	 */
	public void setEstimatedLastVisibleRow(int estimatedLastVisibleRow) {
		this.estimatedLastVisibleRow = estimatedLastVisibleRow;
	}

	@Override
	public final Type<ScrollHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ScrollHandler handler) {
		handler.onScroll(this);
	}

}
