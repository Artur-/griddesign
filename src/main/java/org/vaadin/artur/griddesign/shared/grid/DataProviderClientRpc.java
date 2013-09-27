package org.vaadin.artur.griddesign.shared.grid;

import org.vaadin.artur.griddesign.shared.data.DataSourceData;

import com.vaadin.shared.communication.ClientRpc;

public interface DataProviderClientRpc extends ClientRpc {

	/**
	 * Informs the client that it should forget everything it has cached and
	 * initialize its cache with the given data.
	 * 
	 * @param data
	 *            The data to store in the client side cache
	 * @param estimatedSize
	 *            An estimate of the total size. May or may not be correct.
	 */
	public void initialize(DataSourceData data, int estimatedSize);

	/**
	 * Informs the client that the given number of rows have been inserted at
	 * the given position.
	 * 
	 * @param firstRow
	 *            The index at which the first new row is inserted
	 * @param numberOfRows
	 *            The number of inserted rows
	 */
	public void insertRows(int firstRow, int numberOfRows);

	/**
	 * Informs the client the the given number of rows have been removed from
	 * the given position
	 * 
	 * @param firstRow
	 *            The index of the first removed row
	 * @param numberOfRows
	 *            The number of removed rows
	 */
	public void removeRows(int firstRow, int numberOfRows);

	/**
	 * Informs the client the the data in the given rows has changed and any
	 * cached data for these rows must be updated.
	 * 
	 * @param data
	 *            Data of the rows which have been updated
	 */
	public void updateRows(DataSourceData data);

}
