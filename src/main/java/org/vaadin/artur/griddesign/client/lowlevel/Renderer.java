package org.vaadin.artur.griddesign.client.lowlevel;


/**
 * A renderer is capable of rendering data of a given type into a given cell.s
 * 
 * @param <T>
 *            The type the renderer is capable of rendering
 */
public interface Renderer<T> {

	/**
	 * Renders the given data into
	 * 
	 * @param cell
	 *            The cell to render into
	 * @param data
	 *            The data to render
	 */
	public void render(Cell cell, T data);

	/**
	 * Returns the type this renderer is capable of rendering
	 * 
	 * @return The type of this renderer
	 */
	public Class<T> getType();
}
