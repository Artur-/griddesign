package org.vaadin.artur.griddesign.client.lowlevel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;

/**
 * Low level Grid widget. Features:
 * <ul>
 * <li>Header, body, footer supporting 0-N rows each</li>
 * <li>Colspan support in header, body and footer</li>
 * <li>Infinite scrolling based on the escalator pattern</li>
 * <li>Outsources updating of cell contents to a {@link CellRenderer}</li>
 * <li>Scrolling so that a given row is visible at a given position
 * (top,middle,bottom)</li>
 * <li>Calculating column width based on rendered contents</li>
 * <li>Freeze columns for the 0-N first columns</li>
 * </ul>
 */
public class Escalator<T> extends Widget {

	/*
	 * Out of scope for this:
	 * 
	 * - Drag'n'drop column reordering
	 * 
	 * - Details row (insertRow, index handling done by caller)
	 * 
	 * - Focus handling
	 * 
	 * - Keyboard handling
	 */
	// Logical events

	private RowContainer<T> header;
	private RowContainer<T> body;
	private RowContainer<T> footer;
	private ColumnConfiguration columnConfiguration;

	// Create methods for row containers...

	protected ColumnConfiguration createColumnConfiguration() {
		return GWT.create(ColumnConfiguration.class);
	}

	/**
	 * Scrolls the body vertically so that the given row is visible.
	 * 
	 * @param rowIndex
	 * @param destination
	 */
	public void scrollToRow(int rowIndex, ScrollDestination destination) {
	}

	/**
	 * Scrolls the body vertically so that the given row is visible and there is
	 * at least {@literal padding} pixels to the given scroll destination. Note
	 * that
	 * 
	 * @param rowIndex
	 * @param destination
	 * @param padding
	 */
	public void scrollToRow(int rowIndex, ScrollDestination destination,
			int padding) throws IllegalArgumentException {
	}

	/**
	 * Returns the logical vertical scroll offset. Note that this is not
	 * necessarily the same as the scroll top in the DOM
	 * 
	 * @return
	 */
	public double getScrollTop() {
		return -1;
	}

	/**
	 * Sets the logical vertical scroll offset. Note that this is not
	 * necessarily the same as the scroll top in the DOM
	 * 
	 * @param scrollTop
	 */
	public void setScrollTop(double scrollTop) {
	}

	/**
	 * Scrolls the body vertically so that the given Column is visible.
	 * 
	 * @param columnIndex
	 * @param destination
	 */
	public void scrollToColumn(int columnIndex, ScrollDestination destination) {
	}

	/**
	 * Scrolls the body vertically so that the given Column is visible and there
	 * is at least {@literal padding} pixels to the given scroll destination.
	 * Note that
	 * 
	 * @param columnIndex
	 * @param destination
	 * @param padding
	 */
	public void scrollToColumn(int columnIndex, ScrollDestination destination,
			int padding) throws IllegalArgumentException {
	}

	/**
	 * Returns the logical vertical scroll offset. Note that this is not
	 * necessarily the same as the scroll Left in the DOM
	 * 
	 * @return
	 */
	public int getScrollLeft() {
		return -1;
	}

	/**
	 * Sets the logical vertical scroll offset. Note that this is not
	 * necessarily the same as the scroll Left in the DOM
	 * 
	 * @param scrollLeft
	 */
	public void setScrollLeft(int scrollLeft) {
	}

	/**
	 * Returns the representation of the grid header
	 * 
	 * @return the header
	 */
	public RowContainer getHeader() {
		return header;
	}

	/**
	 * Returns the representation of the grid body
	 * 
	 * @return the body
	 */
	public RowContainer getBody() {
		return body;
	}

	/**
	 * Returns the representation of the grid footer
	 * 
	 * @return the footer
	 */
	public RowContainer getFooter() {
		return footer;
	}

	/**
	 * @return the columnConfiguration
	 */
	public ColumnConfiguration getColumnConfiguration() {
		return columnConfiguration;
	}

}
