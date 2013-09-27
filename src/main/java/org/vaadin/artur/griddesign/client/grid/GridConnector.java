package org.vaadin.artur.griddesign.client.grid;

import org.vaadin.artur.griddesign.client.data.DataContainer;

import com.google.gwt.json.client.JSONArray;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(org.vaadin.artur.griddesign.Grid.class)
public class GridConnector extends AbstractComponentConnector {

	@SuppressWarnings("unchecked")
	@Override
	public Grid<JSONArray> getWidget() {
		return (Grid<JSONArray>) super.getWidget();
	}

	public void setDataContainer(DataContainer<JSONArray> dataContainer) {
		getWidget().setDataContainer(dataContainer);
	}

}
