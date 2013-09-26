package org.vaadin.artur.griddesign;

import com.vaadin.server.ClientConnector;

/**
 * Implemented by server side renderers
 */
public interface Renderer extends ClientConnector {
	/**
	 * Returns the type the client side renderer this is connected
	 * 
	 * @return
	 */
	public Class<?> getType();
}
