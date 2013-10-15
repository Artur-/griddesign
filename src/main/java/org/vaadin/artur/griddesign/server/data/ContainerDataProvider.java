package org.vaadin.artur.griddesign.server.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.vaadin.artur.griddesign.client.rpc.RpcResult;
import org.vaadin.artur.griddesign.shared.data.DataSourceData;
import org.vaadin.artur.griddesign.shared.data.RowIdentifier;
import org.vaadin.artur.griddesign.shared.grid.DataProviderClientRpc;
import org.vaadin.artur.griddesign.shared.grid.DataProviderServerRpc;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.EncodeResult;
import com.vaadin.server.JsonCodec;
import com.vaadin.ui.Component;

/**
 * Server side data source which is connected to a client side DataSource.
 * Communicates the selected container properties to the client whenever the
 * client requests data through RPC or whenever {@link #sendData(int, int)} is
 * invoked.
 * 
 * The DataSource must be attached to the Component which uses it to be able to
 * communicate using {@link #extend(AbstractClientConnector)}.
 */
public class ContainerDataProvider extends AbstractExtension {

	private Container.Indexed container;

	/**
	 * Contains the properties which should be sent to the client
	 */
	private Set<Object> sharedProperties = new HashSet<Object>();
	private Map<Object, Integer> sharedPropertiesToClientSideKey = new HashMap<Object, Integer>();
	private Map<Object, Converter<?, ?>> propertyConverters = new HashMap<Object, Converter<?, ?>>();

	private int nextClientSideKey = 0;

	public ContainerDataProvider() {
		registerRpc(new DataProviderServerRpc() {

			@Override
			public RpcResult<DataSourceData> requestData(int firstRow,
					int numberOfRows) {
				DataSourceData data = null;
				// DataSourceData data = fetchData(firstRow, numberOfRows);
				return RpcResult.create(data);

			}

			@Override
			public void updateClientCacheInfo(RowIdentifier firstRow,
					int numberOfRows) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void sendData(int firstRow, int numberOfRows) {
		DataSourceData data = new DataSourceData();

		data.firstRow = firstRow;

		// FIXME Only components have a Locale
		Locale locale = getLocale();

		List<Object> propertyIdOrder = new ArrayList<Object>(sharedProperties);

		List<Integer> clientKeyOrder = new ArrayList<Integer>();
		for (Object property : propertyIdOrder) {
			Integer clientSideKey = ensureClientSideKey(property);
			clientKeyOrder.add(clientSideKey.intValue());
		}
		data.propertyOrder = clientKeyOrder;

		JSONArray rowDataAsJson = new JSONArray();

		firstRow = rangeCheck(firstRow);
		numberOfRows = rangeCheck(firstRow + numberOfRows) - firstRow;

		List<?> itemIds = container.getItemIds(firstRow, numberOfRows);

		for (Object itemId : itemIds) {
			JSONArray rowData = new JSONArray();
			Item item = container.getItem(itemId);

			for (Object propertyId : propertyIdOrder) {
				Property<?> itemProperty = item.getItemProperty(propertyId);
				Class<?> type = itemProperty.getType();
				Object value = itemProperty.getValue();

				Converter<Object, Object> converter = (Converter<Object, Object>) propertyConverters
						.get(propertyId);
				if (converter != null) {
					type = converter.getPresentationType();
					value = converter
							.convertToPresentation(value, type, locale);
				}

				EncodeResult encodeResult;
				try {
					encodeResult = JsonCodec.encode(value, null, type, getUI()
							.getConnectorTracker());
					rowData.put(encodeResult.getEncodedValue());
				} catch (JSONException e) {
					// FIXME Barf
					e.printStackTrace();
				}

			}
			rowDataAsJson.put(rowData);
		}

		data.rowDataAsJson = rowDataAsJson;

		getRpcProxy(DataProviderClientRpc.class).updateRows(data);
	}

	private Locale getLocale() {
		// FIXME getLocale should be moved up to clientConnector
		return ((Component) getParent()).getLocale();
	}

	private Integer ensureClientSideKey(Object property) {
		Integer key = sharedPropertiesToClientSideKey.get(property);
		if (key == null) {
			key = Integer.valueOf(nextClientSideKey++);
			sharedPropertiesToClientSideKey.put(property, key);
		}
		return key;
	}

	public Converter<?, ?> getPropertyConverter(Object propertyId) {
		// FIXME
		return null;
	}

	public void setPropertyConverter(Object propertyId,
			Converter<?, ?> propertyConverter) {
		propertyConverters.put(propertyId, propertyConverter);
	}

	/**
	 * Ensure the row with the given index exists in the container.
	 * 
	 * @param rowIndex
	 * @return A trimmed down (or set to zero) index which exists in the
	 *         container
	 */
	private int rangeCheck(int rowIndex) {
		if (rowIndex < 0) {
			return 0;
		}
		// FIXME What about undefined container size ??
		int containerSize = container.size();
		if (rowIndex >= containerSize) {
			return containerSize;
		}
		return rowIndex;
	}

	/**
	 * Connects the data source to the given connector
	 */
	@Override
	protected void extend(AbstractClientConnector target) {
		super.extend(target);
	}
}
