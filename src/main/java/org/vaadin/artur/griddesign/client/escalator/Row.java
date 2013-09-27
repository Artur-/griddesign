package org.vaadin.artur.griddesign.client.escalator;

import com.google.gwt.user.client.Element;

/**
 * Representation of a row in a {@link Escalator}
 */
public interface Row {
	/**
	 * @return the {@link Escalator} containing the row
	 */
	public Escalator getEscalator();

	/**
	 * @return the row index
	 */
	public int getRow();

	/**
	 * Return the root element for this row. The {@link EscalatorUpdater} may
	 * update the class names of the element, add inline styles and freely
	 * modify the contents but not the contained DOM structure.
	 * 
	 * Note that modifying the contents of cell elements should be done in
	 * {@link EscalatorUpdater#updateCell(Cell)}, otherwise updates might be
	 * overwritten later.
	 * 
	 * @return The root element of the row
	 */
	public Element getElement();
}