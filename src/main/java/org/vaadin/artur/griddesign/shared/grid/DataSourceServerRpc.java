package org.vaadin.artur.griddesign.shared.grid;

import org.vaadin.artur.griddesign.client.rpc.RpcResult;
import org.vaadin.artur.griddesign.shared.data.DataSourceData;
import org.vaadin.artur.griddesign.shared.data.RowIdentifier;

import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

public interface DataSourceServerRpc extends ServerRpc {

	/**
	 * Called by the client DataProvider whenever the rows it has cached changes
	 * 
	 * @param firstRow
	 * @param numberOfRows
	 */
	@Delayed(lastOnly = true)
	public void updateClientCacheInfo(RowIdentifier firstRow, int numberOfRows);

	public RpcResult<DataSourceData> requestData(int firstIndex,
			int numberOfRows);
}
