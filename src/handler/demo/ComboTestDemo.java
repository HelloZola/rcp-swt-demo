package handler.demo;

import java.awt.PopupMenu;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import handler.IPartDemoInf;

public class ComboTestDemo implements IPartDemoInf {

	static boolean menuRender = false;

	@Override
	public void renderPart(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);

		Shell shell = Display.getCurrent().getActiveShell();
		Image image = new Image(Display.getCurrent(), "C:\\Users\\Administrator\\Desktop\\截图保存\\按钮样式.png");

		Button mockCombo = new Button(composite, SWT.PUSH);
		mockCombo.setSize(150, 20);
		mockCombo.setImage(image);

		Menu menu = new Menu(mockCombo);

		mockCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				System.out.println(mockCombo.getParent().getParent().getParent().getParent().getParent().getParent()
						.getLocation().x);
				System.out.println(mockCombo.getLocation().x);
				int x = mockCombo.getParent().getParent().getParent().getParent().getParent().getParent()
						.getLocation().x + mockCombo.getLocation().x;
				int y = mockCombo.getParent().getParent().getParent().getParent().getParent().getParent()
						.getLocation().y + mockCombo.getLocation().y;

				menu.setLocation(x, y);
				if (!menuRender) {
					menuRender = true;
					Rectangle clientArea = Display.getDefault().getActiveShell().getClientArea();
					mockCombo.setMenu(menu);
					if (true) {
						MenuItem menuitem = new MenuItem(menu, 1);
						menuitem.setImage(image);
						menuitem.setText("testse");
					}
					if (true) {
						MenuItem menuitem = new MenuItem(menu, 1);
						menuitem.setText("testse");
					}
					if (true) {
						MenuItem menuitem = new MenuItem(menu, 1);
						menuitem.setText("testse");
					}
				}
				if (menu.isVisible()) {
					menu.setVisible(false);
				} else {
					menu.setVisible(true);
				}
			}
		});
	}
}
