package others;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet40 {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Snippet 40");
		shell.setLayout(new GridLayout(2, false));
		Composite c1 = new Composite(shell, SWT.BORDER);
		c1.setLayoutData(new GridData(100, 100));
		Composite c2 = new Composite(shell, SWT.BORDER);
		c2.setLayoutData(new GridData(100, 100));
		Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Popup");
		c1.setMenu(menu);
		c2.setMenu(menu);
		shell.setMenu(menu);
		shell.setSize(300, 300);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}