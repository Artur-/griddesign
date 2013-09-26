package org.vaadin.artur.griddesign.client;

import java.util.List;

public interface DataContainer<T> {

	/**
	 * Sets the range that the container should retain. Rows data for rows
	 * outside this range may be discarded by the container..
	 * 
	 * @param firstIndex
	 *            The first index to retain
	 * @param lastIndex
	 *            The last index to retain or -1 to retain all rows from
	 *            firstIndex forward
	 */
	public void setRange(int firstIndex, int lastIndex);

	/**
	 * Checks if the given row data is available in the data container.
	 * 
	 * @param rowIndex
	 *            The row index to check
	 * @return true if the row data is available, false otherwise
	 */
	public boolean hasData(int rowIndex);

	/**
	 * Retrieves the row data for the given rows. If all row data is not
	 * available this may return a list containing fewer elements. The first
	 * element in the returned list is always for the 'firstIndex' row.
	 * 
	 * @param firstIndex
	 *            The first index to retrieve data for
	 * @param lastIndex
	 *            The last index to retreieve data for
	 * @return A list of size 0..(lastIndex-firstIndex+1) depending on how much
	 *         data is available.
	 */
	public List<T> getRows(int firstIndex, int lastIndex);

	/**
	 * Returns an estimate of the number of rows which are in the container.
	 * 
	 * @return The current estimated of the container size
	 */
	public int getEstimatedSize();
}
