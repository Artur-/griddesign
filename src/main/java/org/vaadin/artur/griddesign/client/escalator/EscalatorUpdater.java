package org.vaadin.artur.griddesign.client.escalator;

import java.util.List;

public interface EscalatorUpdater {
	/**
	 * Called whenever one or several cells in a row needs to be updated.
	 * 
	 * @param row
	 *            Information about the row to update
	 * @param cellsToUpdate
	 *            A collection of cells which need to be updated
	 * @return true if the updater is ready to render the cell contents, false
	 *         to delay rendering until later
	 */
	public boolean updateCells(Row row, List<Cell> cellsToUpdate);
}