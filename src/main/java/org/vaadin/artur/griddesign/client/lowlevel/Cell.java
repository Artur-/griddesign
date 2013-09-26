package org.vaadin.artur.griddesign.client.lowlevel;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public interface Cell {
	public Escalator getLowLevelGridWidget();

	/**
	 * Sets the colspan for the given cell. Setting this larger than 1 will
	 * cause the subsequent cells never to be rendered.
	 * 
	 * @param colspan
	 *            the colspan for the cell
	 */
	public void setColspan(int colspan);

	/**
	 * Returns the colspan for the cell. Default is 1.
	 * 
	 * @return the colspan for the cell
	 */
	public int getColspan();

	/**
	 * Returns the widget attached to this cell
	 * 
	 * @return the widget in this cell or null if no widget has been attached
	 */
	public Widget getWidget();

	/**
	 * Attaches the given widget to this cell (and detaches the current widget
	 * if there is one)
	 * 
	 * @param widget
	 *            The widget to attach
	 */
	public void setWidget(Widget widget);

	public int getRow();

	public int getColumn();

	/**
	 * Return the root element for this cell. The {@link CellRenderer} may
	 * update the class names of the element, add inline styles and freely
	 * modify the contents.
	 * 
	 * @return
	 */
	public Element getElement();
}