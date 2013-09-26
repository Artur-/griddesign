package org.vaadin.artur.griddesign.client.highlevel;

import java.util.List;

import org.vaadin.artur.griddesign.client.DataContainer;
import org.vaadin.artur.griddesign.client.lowlevel.Cell;
import org.vaadin.artur.griddesign.client.lowlevel.Escalator;
import org.vaadin.artur.griddesign.client.lowlevel.EscalatorUpdater;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

public class Grid<ROWTYPE> extends Composite {

	public interface Renderer<T> {
		public void renderCell(Cell cell, T data);
	}

	private final Escalator<ROWTYPE> escalator;

	private List<Column<ROWTYPE, ?>> columns;

	private DataContainer dataContainer;

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

		getEscalator().getBody().setEscalatorUpdater(
				new EscalatorUpdater<ROWTYPE>() {
					@Override
					public void updateCell(ROWTYPE row, Cell cell) {
						Object cellValue = getColumn(cell.getColumn())
								.getValue(row);
						getRenderer(cell.getColumn()).render(cell, data);
					}
				});
	}

	protected Renderer<?> getRenderer(int column) {
		// FIXME
		return null;
	}

	protected void getGridDataSource() {
		// ...

	}

	protected Escalator createEscalator() {
		return GWT.create(Escalator.class);
	}

	public void insertColumn(int index, Column<ROWTYPE, ?> column) {
		columns.add(index, column);
		getEscalator().getColumnConfiguration().insertColumns(index, 1);
	}

	public Escalator<ROWTYPE> getEscalator() {
		return escalator;
	}

	public void removeColumn(int index) {
		columns.remove(index);
		getEscalator().getColumnConfiguration().removeColumns(index, 1);
	}

	public Column getColumn(int index) {
		return columns.get(index);
	}

	public void setDataContainer(DataContainer dataContainer) {
		this.dataContainer = dataContainer;
	}
}
