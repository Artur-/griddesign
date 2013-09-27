package org.vaadin.artur.griddesign.client.escalator;

import org.vaadin.artur.griddesign.client.escalator.event.RangeChangeEvent;
import org.vaadin.artur.griddesign.client.escalator.event.RangeChangeHandler;

public class DefaultEscalatorRangeChangeHandler implements RangeChangeHandler {

	@Override
	public void onRangeChange(RangeChangeEvent rangeChangeEvent) {
		int numberOfRows = rangeChangeEvent.getEstimatedLastVisibleRow()
				- rangeChangeEvent.getEstimatedFirstVisibleRow() + 1;
		rangeChangeEvent.getRowContainer().refreshRows(
				rangeChangeEvent.getEstimatedFirstVisibleRow(), numberOfRows);
	}
}
