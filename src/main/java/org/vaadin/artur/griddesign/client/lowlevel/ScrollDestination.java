package org.vaadin.artur.griddesign.client.lowlevel;

public enum ScrollDestination {
	/**
	 * "scrollIntoView" i.e. scroll as little as possible to show the target
	 * element. If the element fits into view, this works as START or END
	 * depending on the current scroll position. If the element does not fit
	 * into view, this works as START.
	 */
	ANY,
	/**
	 * Scrolls so that the element is shown at the start of the view port
	 */
	START,
	/**
	 * Scrolls so that the element is shown in the middle of the view port
	 */
	MIDDLE,
	/**
	 * Scrolls so that the element is shown at the end of the view port
	 */
	END
}