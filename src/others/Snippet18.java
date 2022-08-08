package others;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet18 {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Snippet 18");
		ToolBar bar = new ToolBar(shell, SWT.BORDER);
		for (int i = 0; i < 8; i++) {
			ToolItem item = new ToolItem(bar, SWT.PUSH);
			item.setText("Item " + i);
		}
		Rectangle clientArea = shell.getClientArea();
		bar.setLocation(clientArea.x, clientArea.y);
		bar.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}

