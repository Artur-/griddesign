package org.vaadin.artur.griddesign.client.lowlevel;

public interface RowContainer<T> {
	public EscalatorUpdater<T> getEscalatorUpdater();

	public void setEscalatorUpdater(EscalatorUpdater<T> escalatorUpdater);

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
	 * Returns the number of rows in the container
	 * 
	 * @return
	 */
	public int getNumberOfRows();

	/**
	 * Sets the height of the given row
	 * 
	 * @param rowIndex
	 * @param height
	 */
	public void setRowHeight(int rowIndex, double height);
}