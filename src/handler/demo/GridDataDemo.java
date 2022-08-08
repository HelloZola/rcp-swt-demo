package handler.demo;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import handler.IPartDemoInf;

public class GridDataDemo implements IPartDemoInf {

	@Override
	public void renderPart(Composite parent) {

		parent.setLayout(new FillLayout());

		Composite mainComposite = new Composite(parent, SWT.BORDER);
		mainComposite.setToolTipText("mainComposite");
		mainComposite.setLayout(new FillLayout());

		Composite toolbarComposite = new Composite(mainComposite, SWT.NONE);
		toolbarComposite.setLayout(new GridLayout(2, false));

		toolbarComposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, false, 2, 0));
		Button b = new Button(toolbarComposite, SWT.PUSH);
		b.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));
		b.setText("LEFT, TOP");

		Button b2 = new Button(toolbarComposite, SWT.PUSH);
		b2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true, 1, 1));
		b2.setText("LEFT, TOP");
	}

	private static GridLayout getGridLayout() {
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		return layout;
	}

	/**
	 * Sets the layout properties.
	 *
	 * @param parent the new layout properties
	 */
	public static void setLayoutProperties(Composite parent) {

		GridLayout gridlayout = new GridLayout();
		gridlayout.marginTop = 0;
		gridlayout.marginBottom = 0;
		gridlayout.marginRight = 0;
		gridlayout.marginLeft = 0;
		gridlayout.marginHeight = 0;
		gridlayout.marginWidth = 0;
		gridlayout.verticalSpacing = 0;
		gridlayout.horizontalSpacing = 0;
		parent.setLayout(gridlayout);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
	}

}
