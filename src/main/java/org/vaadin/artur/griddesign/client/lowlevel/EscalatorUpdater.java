package org.vaadin.artur.griddesign.client.lowlevel;

public interface EscalatorUpdater<T> {
	public void updateRow(Row row);

	public void updateCell(T row, Cell cell);
}