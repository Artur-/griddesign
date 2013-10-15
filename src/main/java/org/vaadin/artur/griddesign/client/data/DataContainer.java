package org.vaadin.artur.griddesign.client.data;

public interface DataContainer<T> {

	/**
	 * Informs the data container that data for the given range will be needed
	 * in the future.
	 * 
	 * Calling this method may trigger lazy loading of data.
	 * 
	 * @param firstIndex
	 *            The first index needed
	 * @param lastIndex
	 *            The last index needed
	 */
	public void ensureAvailability(int firstIndex, int lastIndex);

	/**
	 * Retrieves the row data for the given row. If the row data is not
	 * available, returns null.
	 * 
	 * Calling this method does not trigger loading of unavailable data (use
	 * {@link #ensureAvailability(int, int)}).
	 * 
	 * @param rowIndex
	 *            The row to retrieve data for
	 * @return Data for the row or null if no data is available
	 */
	public T getRow(int rowIndex);

	/**
	 * Returns an estimate of the number of rows which are in the container.
	 * 
	 * @return The current estimated of the container size
	 */
	public int getEstimatedSize();
}
