package others;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet169 {
public static void main (String [] args) {
	Display display = new Display ();
	final Shell shell = new Shell (display);
	shell.setText("Snippet 169");
	shell.setLayout (new FillLayout ());
	Listener listener = e -> {
		Control [] children = shell.getChildren ();
		for (Control child : children) {
			if (e.widget != child && child instanceof Button && (child.getStyle () & SWT.TOGGLE) != 0) {
				((Button) child).setSelection (false);
			}
		}
		((Button) e.widget).setSelection (true);
	};
	for (int i=0; i<20; i++) {
		Button button = new Button (shell, SWT.TOGGLE);
		button.setText ("B" + i);
		button.addListener (SWT.Selection, listener);
		if (i == 0) button.setSelection (true);
	}
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}