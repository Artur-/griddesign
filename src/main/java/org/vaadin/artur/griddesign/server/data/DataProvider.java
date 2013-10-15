package org.vaadin.artur.griddesign.server.data;

import org.vaadin.artur.griddesign.shared.grid.DataProviderServerRpc;

import com.vaadin.server.AbstractClientConnector;

public abstract class DataProvider extends AbstractClientConnector {

	public DataProvider() {
		registerRpc(createDataProviderRpc());
	}

	protected abstract DataProviderServerRpc createDataProviderRpc();

}
