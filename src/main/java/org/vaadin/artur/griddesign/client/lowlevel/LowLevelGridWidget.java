package org.vaadin.artur.griddesign.client.lowlevel;

import com.google.gwt.user.client.Element;
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
public class LowLevelGridWidget extends Widget {

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

	public interface CellRenderer {
		public void renderCell(Cell cell);
	}

	public interface Cell {
		public LowLevelGridWidget getLowLevelGridWidget();

		/**
		 * Sets the colspan for the given cell. Setting this larger than 1 will
		 * cause the subsequent cells never to be rendered.
		 * 
		 * @param colspan
		 *            the colspan for the cell
		 */
		public void setColspan(int colspan);

		/**
		 * Returns the colspan for the cell. Default is 1.
		 * 
		 * @return the colspan for the cell
		 */
		public int getColspan();

		/**
		 * Returns the widget attached to this cell
		 * 
		 * @return the widget in this cell or null if no widget has been
		 *         attached
		 */
		public Widget getWidget();

		/**
		 * Attaches the given widget to this cell (and detaches the current
		 * widget if there is one)
		 * 
		 * @param widget
		 *            The widget to attach
		 */
		public void setWidget(Widget widget);

		public int getRow();

		public int getColumn();

		/**
		 * Return the root element for this cell. The {@link CellRenderer} may
		 * update the class names of the element, add inline styles and freely
		 * modify the contents.
		 * 
		 * @return
		 */
		public Element getElement();
	}

	public interface ColumnConfiguration {

		/**
		 * Informs the widget that columns have been removed from the table.
		 * 
		 * @param offset
		 * @param numberOfColumns
		 */
		public void removeColumns(int offset, int numberOfColumns);

		/**
		 * Informs the widget that new Columns have been inserted in the table.
		 * 
		 * @param offset
		 * @param numberOfColumns
		 */
		public void insertColumns(int offset, int numberOfColumns);

		/**
		 * Informs the widget the Columns have been updated.
		 * 
		 * @param offset
		 * @param numberOfColumns
		 */
		public void refreshColumns(int offset, int numberOfColumns);

		/**
		 * Move an existing column to a new position
		 * 
		 * @param columnIndex
		 * @param newIndex
		 */
		// public void moveColumn(int columnIndex, int newIndex);

		/**
		 * Freezes the {@literal nr} first columns so that scrolling does not
		 * affect them
		 * 
		 * @param nr
		 */
		public void setFrozenColumns(int nr);

		/**
		 * Returns the number of columns in the table
		 * 
		 * @return
		 */
		public int getNumberOfColumns();

		/**
		 * Sets the width of the given column
		 * 
		 * @param columnIndex
		 * @param width
		 *            The width in pixels or -1 to use auto sizing
		 */
		public void setColumnWidth(int columnIndex, int width);

		/**
		 * Returns the width of the given column
		 * 
		 * @param columnIndex
		 * @return The width in pixels or -1 if using auto sizing and the column
		 *         width has not yet been calculated
		 */
		public int getColumnWidth(int columnIndex);

		/**
		 * Calculates the automatic width of columns
		 */
		public void calculateColumnWidths();

	}

	public interface RowContainer {
		public CellRenderer getCellUpdater();

		public void setCellUpdater(CellRenderer cellUpdater);

		/**
		 * Informs the widget that rows have been removed from the table.
		 * 
		 * @param offset
		 * @param numberOfRows
		 */
		public void removeRows(int offset, int numberOfRows);

		/**
		 * Informs the widget that new rows have been inserted in the table.
		 * 
		 * @param offset
		 * @param numberOfRows
		 */
		public void insertRows(int offset, int numberOfRows);

		/**
		 * Informs the widget the rows have been updated.
		 * 
		 * @param offset
		 * @param numberOfRows
		 */
		public void refreshRows(int offset, int numberOfRows);

		/**
		 * Sets the height of the given row
		 * 
		 * @param rowIndex
		 * @param height
		 */
		public void setRowHeight(int rowIndex, int height);
	}

	public enum ScrollDestination {
		/**
		 * "scrollIntoView" i.e. scroll as little as possible to show the target
		 * element. If the element fits into view, this works as START or END
		 * depending on the current scroll position. If the element does not fit
		 * into view, this works as START.
		 */
		ANY,
		/**
		 * Scrolls so that the element is shown at the start of the view port
		 */
		START,
		/**
		 * Scrolls so that the element is shown in the middle of the view port
		 */
		MIDDLE,
		/**
		 * Scrolls so that the element is shown at the end of the view port
		 */
		END
	}

	private RowContainer header;
	private RowContainer body;
	private RowContainer footer;

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
	public int getScrollTop() {
		return -1;
	}

	/**
	 * Sets the logical vertical scroll offset. Note that this is not
	 * necessarily the same as the scroll top in the DOM
	 * 
	 * @param scrollTop
	 */
	public void setScrollTop(int scrollTop) {
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

}
