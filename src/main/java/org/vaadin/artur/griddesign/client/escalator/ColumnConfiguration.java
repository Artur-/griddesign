package org.vaadin.artur.griddesign.client.escalator;

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
	public void moveColumn(int columnIndex, int newIndex);

	/**
	 * Freezes the {@literal nr} first columns so that scrolling does not affect
	 * them
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
	public void setColumnWidth(int columnIndex, double width);

	/**
	 * Returns the width of the given column
	 * 
	 * @param columnIndex
	 * @return The width in pixels or -1 if using auto sizing and the column
	 *         width has not yet been calculated
	 */
	public double getColumnWidth(int columnIndex);

	/**
	 * Calculates the automatic width of columns
	 */
	public void calculateColumnWidths();

}