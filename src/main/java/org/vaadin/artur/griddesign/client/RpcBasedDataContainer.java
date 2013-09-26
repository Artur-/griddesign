package org.vaadin.artur.griddesign.client;

import java.util.List;

import org.vaadin.artur.griddesign.DataProvider;
import org.vaadin.artur.griddesign.shared.DataProviderClientRpc;
import org.vaadin.artur.griddesign.shared.DataSourceData;

import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

@Connect(DataProvider.class)
public class RpcBasedDataContainer extends AbstractExtensionConnector implements
		DataContainer {
	/**
	 * Sets the range that the container should retain. Rows data for rows
	 * outside this range will be discarded automatically.
	 * 
	 * @param firstIndex
	 *            The first index to retain
	 * @param lastIndex
	 *            The last index to retain or -1 to retain all rows
	 */
	@Override
	public void setRange(int firstIndex, int lastIndex);

	@Override
	protected void init() {
		super.init();

		registerRpc(new DataProviderClientRpc() {

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
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	protected void extend(ServerConnector target) {
		if (target instanceof HasRpcBasedDataContainer) {
			getOwner().setRpcBasedDataContainer(this);
		} else {
			throw new RuntimeException(getClass().getName()
					+ " must be connected to a "
					+ HasRpcBasedDataContainer.class.getName());
		}
	}

	private HasRpcBasedDataContainer getOwner() {
		return (HasRpcBasedDataContainer) getParent();
	}

	@Override
	public void onUnregister() {
		super.onUnregister();
		getOwner().setRpcBasedDataContainer(null);
	}

	@Override
	public boolean hasData(int rowIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getRows(int firstIndex, int lastIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEstimatedSize() {
		// TODO Auto-generated method stub
		return 0;
	}
}
