package org.vaadin.artur.griddesign.client.rpc;

public abstract class RpcResult<T> {

	public abstract void addCallback(RpcCallback<T> rpcCallback);

	public static <T> RpcResult<T> create(T t) {
		// ...
		return null;
	}
}
