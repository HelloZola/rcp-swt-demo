package handler.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import handler.IPartDemoInf;

public class ButtonTestDemo implements IPartDemoInf {

	@Override
	public void renderPart(Composite parent) {

		Button b1 = new Button(parent, SWT.NONE);
		b1.setText("But1");
		b1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox dialog = new MessageBox(Display.getCurrent().getActiveShell());
				dialog.setText("FDFSd");
				dialog.open();
			}
		});
	}

}
