package org.vaadin.artur.griddesign.client.rpc;

public interface RpcCallback<T> {
	public void onResult(T result);
}