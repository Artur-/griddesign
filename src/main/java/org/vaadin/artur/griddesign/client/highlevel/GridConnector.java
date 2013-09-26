package org.vaadin.artur.griddesign.client.highlevel;

import org.vaadin.artur.griddesign.client.HasRpcBasedDataContainer;
import org.vaadin.artur.griddesign.client.RpcBasedDataContainer;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(org.vaadin.artur.griddesign.Grid.class)
public class GridConnector extends AbstractComponentConnector implements
		HasRpcBasedDataContainer {

	@Override
	public Grid getWidget() {
		return (Grid) super.getWidget();
	}

	@Override
	public void setRpcBasedDataContainer(RpcBasedDataContainer dataContainer) {
		getWidget().setDataContainer(dataContainer);
	}

}
