package org.vaadin.artur.griddesign.client.grid;

import org.vaadin.artur.griddesign.client.data.DataContainer;
import org.vaadin.artur.griddesign.client.data.DataSourceCallback;
import org.vaadin.artur.griddesign.client.escalator.event.RangeChangeEvent;
import org.vaadin.artur.griddesign.client.escalator.event.RangeChangeHandler;

public class DataContainerRangeChangeHandler implements RangeChangeHandler {

	private DataContainer<?> dataContainer;

	public DataContainerRangeChangeHandler(DataContainer<?> dataContainer) {
		this.dataContainer = dataContainer;
	}

	@Override
	public void onRangeChange(final RangeChangeEvent event) {
		double cacheRate = 2;

		int escalatorFirstRow = event.getEstimatedFirstVisibleRow();
		int escalatorLastRow = event.getEstimatedLastVisibleRow();

		int estimatedVisibleRows = escalatorLastRow - escalatorFirstRow + 1;
		int firstRowToCache = (int) (escalatorFirstRow - cacheRate
				* estimatedVisibleRows);
		int lastRowToCache = (int) (escalatorLastRow + cacheRate
				* estimatedVisibleRows);

		dataContainer.setRange(firstRowToCache, lastRowToCache,
				new DataSourceCallback() {
					public void dataAvailable(int firstRowAvailable,
							int lastRowAvailable) {
						event.getRowContainer().refreshRows(firstRowAvailable,
								lastRowAvailable);
					}
				});
	}

}
