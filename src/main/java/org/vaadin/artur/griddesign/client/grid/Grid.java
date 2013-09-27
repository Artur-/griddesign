package org.vaadin.artur.griddesign.client.grid;

import java.util.List;

import org.vaadin.artur.griddesign.client.data.DataContainer;
import org.vaadin.artur.griddesign.client.escalator.Cell;
import org.vaadin.artur.griddesign.client.escalator.Escalator;
import org.vaadin.artur.griddesign.client.escalator.EscalatorUpdater;
import org.vaadin.artur.griddesign.client.escalator.Row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

public class Grid<ROWTYPE> extends Composite {

	public interface Renderer<T> {
		public void render(Cell cell, T data);
	}

	private final Escalator escalator;

	private List<Column<ROWTYPE, ?>> columns;

	private DataContainer<ROWTYPE> dataContainer;

	public enum SortDirection {
		ASCENDING, DESCENDING, UNSORTED;
	}

	public static abstract class Column<ROWTYPE, RENDERERTYPE> {
		private Renderer<RENDERERTYPE> renderer;
		private HorizontalAlignmentConstant horizontalAlignment;
		public SortDirection sortDirection;

		// ...

		public abstract RENDERERTYPE getValue(ROWTYPE row);
	}

	public Grid() {
		escalator = createEscalator();
		initWidget(escalator);

		// getEscalator().getHeader().setEscalatorUpdater(new EscalatorUpdater()
		// {
		// @Override
		// public void updateCell(Cell cell) {
		//
		// }
		// });

		getEscalator().getBody().setEscalatorUpdater(new EscalatorUpdater() {
			@Override
			public boolean updateCells(Row row, List<Cell> cellsToUpdate) {
				int rowIndex = escalatorToGridRowIndex(row.getRow());

				// Possibly update row styles
				// setStyle(rowIndex%2 == 0 ? "even":"odd");

				ROWTYPE rowData = dataContainer.getRow(rowIndex);
				if (rowData == null) {
					// Data not available
					return false;
				}

				for (Cell cell : cellsToUpdate) {
					if (!cell.isVisible()) {
						continue;
					}

					Object cellData = getColumn(cell.getColumn()).getValue(
							rowData);
					getRenderer(cell.getColumn()).render(cell, cellData);
				}

				return true;
			}
		});
	}

	protected int escalatorToGridRowIndex(int row) {
		// FIXME Details rows / hierarchy
		return row;
	}

	protected Renderer<Object> getRenderer(int column) {
		// FIXME
		return null;
	}

	protected DataContainer<ROWTYPE> getDataContainer() {
		return dataContainer;
	}

	protected Escalator createEscalator() {
		return GWT.create(Escalator.class);
	}

	public void insertColumn(int index, Column<ROWTYPE, ?> column) {
		columns.add(index, column);
		getEscalator().getColumnConfiguration().insertColumns(index, 1);
	}

	public Escalator getEscalator() {
		return escalator;
	}

	public void removeColumn(int index) {
		columns.remove(index);
		getEscalator().getColumnConfiguration().removeColumns(index, 1);
	}

	public Column getColumn(int index) {
		return columns.get(index);
	}

	public void setDataContainer(DataContainer<ROWTYPE> dataContainer) {
		this.dataContainer = dataContainer;
		getEscalator().setRangeChangeHandler(
				new DataContainerRangeChangeHandler(getDataContainer()));

	}
}
