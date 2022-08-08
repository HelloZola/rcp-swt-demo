package others;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class FillLayoutDemo {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Snippet 172");
		// 充满式布局
		shell.setLayout(new FillLayout());

		Composite composite = new Composite(shell, SWT.NONE);
		GridLayout layout = new GridLayout(4, false);
		composite.setLayout(layout);

		Button b = new Button(composite, SWT.PUSH);
		b.setText("LEFT, TOP");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));
		
		b = new Button(composite, SWT.PUSH);
		b.setText("LEFT, CENTER");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		
		b = new Button(composite, SWT.PUSH);
		b.setText("LEFT, BOTTOM");
		b.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, true, true, 1, 1));
		
		Composite composite2 = new Composite(composite,SWT.NONE);
		composite2.setLayout(new FillLayout());
		b = new Button(composite2, SWT.PUSH);
		b.setText("LEFT, FILL");
		b.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, true, 1, 1));
		
		b = new Button(composite2, SWT.PUSH);
		b.setText("LEFT, FILL");
		b.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, true, 1, 1));
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}