package work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class SharedTextColors implements ISharedTextColors {

	/** The display table. */
	private Map<Display, Map<RGB, Color>> fDisplayTable;

	/** Creates an returns a shared color manager. */
	public SharedTextColors() {
		super();
	}

	@Override
	public Color getColor(RGB rgb) {
		if (rgb == null)
			return null;

		if (fDisplayTable == null)
			fDisplayTable= new HashMap<>(2);

		final Display display= Display.getCurrent();

		Map<RGB, Color> colorTable= fDisplayTable.get(display);
		if (colorTable == null) {
			colorTable= new HashMap<>(10);
			fDisplayTable.put(display, colorTable);
			display.disposeExec(() -> dispose(display));
		}

		Color color= colorTable.get(rgb);
		if (color == null) {
			color= new Color(display, rgb);
			colorTable.put(rgb, color);
		}

		return color;
	}

	@Override
	public void dispose() {
		if (fDisplayTable == null)
			return;

		Iterator<Map<RGB, Color>> iter= fDisplayTable.values().iterator();
		while (iter.hasNext())
			dispose(iter.next());
		fDisplayTable= null;
	}

	/**
	 * Disposes the colors for the given display.
	 *
	 * @param display the display for which to dispose the colors
	 * @since 3.3
	 */
	private void dispose(Display display) {
		if (fDisplayTable != null)
			dispose(fDisplayTable.remove(display));
	}

	/**
	 * Disposes the given color table.
	 *
	 * @param colorTable the color table that maps <code>RGB</code> to <code>Color</code>
	 * @since 3.3
	 */
	private void dispose(Map<RGB, Color> colorTable) {
		if (colorTable != null) {
			colorTable.clear();
		}
	}

}