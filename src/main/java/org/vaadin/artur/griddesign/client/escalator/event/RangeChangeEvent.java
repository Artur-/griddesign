package org.vaadin.artur.griddesign.client.escalator.event;

import org.vaadin.artur.griddesign.client.escalator.Escalator;
import org.vaadin.artur.griddesign.client.escalator.RowContainer;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.GwtEvent;

public class RangeChangeEvent extends GwtEvent<RangeChangeHandler> {

	int estimatedFirstVisibleRow;
	int estimatedLastVisibleRow;
	private Escalator escalator;
	private RowContainer rowContainer;

	/**
	 * Event type for scroll events. Represents the meta-data associated with
	 * this event.
	 */
	private static final Type<RangeChangeHandler> TYPE = new Type<RangeChangeHandler>();

	/**
	 * Gets the event type associated with scroll events.
	 * 
	 * @return the handler type
	 */
	public static Type<RangeChangeHandler> getType() {
		return TYPE;
	}

	/**
	 * Protected constructor, use
	 * {@link DomEvent#fireNativeEvent(com.google.gwt.dom.client.NativeEvent, com.google.gwt.event.shared.HasHandlers)}
	 * to fire scroll events.
	 */
	protected RangeChangeEvent() {
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
	public final Type<RangeChangeHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RangeChangeHandler handler) {
		handler.onRangeChange(this);
	}

	public void setRowContainer(RowContainer rowContainer) {
		this.rowContainer = rowContainer;
	}

	public RowContainer getRowContainer() {
		return rowContainer;
	}

}
