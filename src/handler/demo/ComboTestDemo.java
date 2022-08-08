package handler.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import handler.IPartDemoInf;

public class ComboTestDemo implements IPartDemoInf {

	static boolean menuRender = false;

	private static Integer[] itemsValues = new Integer[] { 1, 1, 1, 1, 1 };

	@Override
	public void renderPart(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);

		Shell shell = Display.getCurrent().getActiveShell();
		Image image = new Image(Display.getCurrent(), "C:\\Users\\Administrator\\Desktop\\截图保存\\编组.png");

		Composite composite2 = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false, 0, 0);
		GridLayout layout = new GridLayout(10, false);
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		composite2.setLayout(layout);

//		GridData butGD = new GridData(151, 23);
		GridData butGD = new GridData(176, 23);
		Button mockCombo = new Button(composite2, SWT.PUSH);
		mockCombo.setLayoutData(butGD);
		mockCombo.setSize(152, 30);
		mockCombo.setImage(image);

//		Button mockCombo2 = new Button(composite, SWT.PUSH);
//		mockCombo2.setSize(150, 20);
//		mockCombo2.setImage(image);

		Menu menu = new Menu(mockCombo);
		Image Itemimage = new Image(Display.getCurrent(),
				"E:\\eclipse-projects\\DataStudio-Zola\\code\\datastudio\\src\\org.opengauss.mppdbide.view\\icons\\checked.png");

		mockCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				Point point = mockCombo.getParent().toDisplay(mockCombo.getLocation());
				int x = point.x;
				int y = point.y + 22;

				menu.setLocation(x, y);
				if (!menuRender) {
					menuRender = true;
					Rectangle clientArea = Display.getDefault().getActiveShell().getClientArea();
					mockCombo.setMenu(menu);
					String[] items = new String[] { "显示图标   ", "显示数据类型 ", "显示是否为空 ", "显示注释信息 ", "显示全限定名称" };
					int i = 0;
					mockCombo.setMenu(menu);
					for (String item : items) {
						MenuItem menuitem = new MenuItem(menu, SWT.CHECK | SWT.DROP_DOWN);
//						menuitem.setImage(Itemimage);
						menuitem.setText(item);
						menuitem.setSelection(true);
						menuitem.setSelection(itemsValues[i] == 1);
						this.addMenuItemSelectEvent(menuitem, i++);
					}
				}
				if (menu.isVisible()) {
					menu.setVisible(false);
				} else {
					menu.setVisible(true);
				}
			}

			private void addMenuItemSelectEvent(MenuItem menuitem, int seq) {
				menuitem.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent arg0) {
						if (itemsValues[seq] == 1) {
//							menuitem.setImage(null);
							itemsValues[seq] = 0;
						} else {
//							menuitem.setImage(Itemimage);
							itemsValues[seq] = 1;
						}
					}
				});
			}
		});
	}

}
