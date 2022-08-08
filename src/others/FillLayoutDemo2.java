package others;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * 充满布局的第二种方式
 * 
 * @author Administrator
 *
 */
public class FillLayoutDemo2 {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Snippet 172");
		// 充满式布局
		shell.setLayout(new GridLayout(1, false));
		GridDataFactory.fillDefaults().grab(true, true).applyTo(shell);

		Layout layout2 = shell.getLayout();

		Composite main = new Composite(shell, SWT.NONE);
		main.setLayout(new GridLayout(1, false));
		GridDataFactory.fillDefaults().grab(true, true).applyTo(main);
//		main.setLayout(new FillLayout());

		Composite composite = new Composite(main, SWT.NONE);
		GridLayout layout = new GridLayout(4, false);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
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
		b = new Button(composite, SWT.PUSH);
		b.setText("LEFT, FILL");

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}