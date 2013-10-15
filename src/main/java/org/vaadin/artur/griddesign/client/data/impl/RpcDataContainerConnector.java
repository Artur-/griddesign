package org.vaadin.artur.griddesign.client.data.impl;

import org.vaadin.artur.griddesign.client.data.DataContainer;
import org.vaadin.artur.griddesign.client.data.HasDataContainer;
import org.vaadin.artur.griddesign.server.data.ContainerDataProvider;
import org.vaadin.artur.griddesign.shared.data.DataSourceData;
import org.vaadin.artur.griddesign.shared.grid.DataProviderClientRpc;

import com.google.gwt.json.client.JSONArray;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

@Connect(ContainerDataProvider.class)
public class RpcDataContainerConnector extends AbstractExtensionConnector {

	private DataContainer<JSONArray> dataContainer = new DataContainer<JSONArray>() {
		//
		// @Override
		// public void setRange(final int firstIndex, final int lastIndex,
		// final DataSourceCallback dataSourceCallback) {
		// RpcResult<DataSourceData> result = getRpcProxy(
		// DataProviderServerRpc.class).requestData(firstIndex,
		// lastIndex - firstIndex + 1);
		// result.addCallback(new RpcCallback<DataSourceData>() {
		// @Override
		// public void onResult(DataSourceData result) {
		// // Data received from the server
		//
		// // TODO store in cache
		//
		// int numberOfReturnedRows = ((JSONArray) result.rowDataAsJson)
		// .size();
		// dataSourceCallback.dataAvailable(result.firstRow,
		// result.firstRow + numberOfReturnedRows);
		// }
		// });
		// }

		@Override
		public JSONArray getRow(int rowIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getEstimatedSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void ensureAvailability(int firstIndex, int lastIndex) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	protected void init() {
		super.init();

		registerRpc(DataProviderClientRpc.class, new DataProviderClientRpc() {

			@Override
			public void updateRows(DataSourceData data) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removeRows(int firstRow, int numberOfRows) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertRows(int firstRow, int numberOfRows) {
				// TODO Auto-generated method stub

			}

			@Override
			public void initialize(DataSourceData data, int estimatedSize) {
			}
		});
	}

	@Override
	protected void extend(ServerConnector target) {
		if (target instanceof HasDataContainer) {
			getOwner().setDataContainer(getDataContainer());
		} else {
			throw new RuntimeException(getClass().getName()
					+ " must be connected to a "
					+ HasDataContainer.class.getName());
		}
	}

	private HasDataContainer getOwner() {
		return (HasDataContainer) getParent();
	}

	@Override
	public void onUnregister() {
		super.onUnregister();
		getOwner().setDataContainer(null);
	}

	public DataContainer<JSONArray> getDataContainer() {
		return dataContainer;
	}
}
