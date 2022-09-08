package work;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableCreateDemo {

	public void createTable(Composite compositeGeneral) {

		GridLayout parGridLyout = (GridLayout) compositeGeneral.getLayout();
		parGridLyout.marginTop = 0;
		parGridLyout.marginLeft = 0;
		parGridLyout.marginHeight = 0;
		parGridLyout.horizontalSpacing = 0;
		compositeGeneral.setLayout(parGridLyout);
		compositeGeneral.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		Composite tableComposite = new Composite(compositeGeneral, SWT.BORDER);
		GridLayout gridLyout = new GridLayout(2, false);
		gridLyout.marginBottom = 0;
		gridLyout.marginTop = 0;
		gridLyout.marginLeft = 0;
		gridLyout.marginRight = 0;
		gridLyout.marginWidth = 0;
		gridLyout.marginHeight = 0;
		gridLyout.horizontalSpacing = 0;
		gridLyout.verticalSpacing = 0;

		tableComposite.setLayout(gridLyout);

		GridData gg = new GridData(SWT.FILL, SWT.TOP, true, true);
		gg.heightHint = 190;
		gg.minimumHeight = 190;

		tableComposite.setLayoutData(gg);
		tableComposite.setBackground(new Color(new RGB(255, 255, 255)));

		Composite tableCompositeSub = new Composite(tableComposite, SWT.NONE);
		GridLayout gfg2 = new GridLayout();
		gfg2.marginBottom = 0;
		gfg2.marginTop = 0;
		gfg2.marginLeft = 0;
		gfg2.marginRight = 0;
		gfg2.marginWidth = 0;
		gfg2.marginHeight = 0;
		gfg2.horizontalSpacing = 0;

		tableCompositeSub.setLayout(gfg2);

		GridData griddata2 = new GridData(SWT.FILL, SWT.FILL, true, true);
		griddata2.widthHint = 453;
		tableCompositeSub.setLayoutData(griddata2);
		tableCompositeSub.setBackground(new Color(new RGB(255, 255, 255)));

		this.createDefTable(tableCompositeSub);
		this.createIcon(tableComposite);
	}

	private void createIcon(Composite tableComposite) {

		Composite iconComposite = new Composite(tableComposite, SWT.BORDER);
		iconComposite.setLayout(new GridLayout());
		GridData griddata2 = new GridData(SWT.FILL, SWT.TOP, true, true);
		griddata2.heightHint = 190;
		iconComposite.setLayoutData(griddata2);

		Image image = new Image(Display.getCurrent(), "C:\\Users\\Administrator\\Desktop\\截图保存\\TB037_1.png");
		Image image2 = new Image(Display.getCurrent(), "C:\\Users\\Administrator\\Desktop\\截图保存\\TB037_1.png");

		Button but = new Button(iconComposite, SWT.None);
		but.setSize(5, 5);
		but.setImage(image);

		Button but2 = new Button(iconComposite, SWT.None);
		but2.setSize(5, 5);
		but2.setImage(image);
	}

	private void createDefTable(Composite tableCompositeSub) {

		Table table = new Table(tableCompositeSub, SWT.MULTI | SWT.BORDER_DASH | SWT.NO_SCROLL | SWT.V_SCROLL);
//		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.NO_SCROLL | SWT.V_SCROLL);

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.TOP, true, true);
		String[] titles = { "模式", "表/视图", "列", "列名" };
		int[] lens = { 100, 100, 130, 119 };
		int le = 0;

		TableViewer v = new TableViewer(table);

		for (String title : titles) {
			TableColumn column = new TableColumn(table, SWT.BORDER_DASH);
			column.setWidth(lens[le++]);
			column.setText(title);

			// todo
			// TableViewerColumn viewerColumn = new TableViewerColumn(v, column);
			// viewerColumn.setLabelProvider(null);
		}
		int count = 2;
		for (int i = 0; i < count; i++) {
			Composite com = new PrivilegeCheckSelectCombo(table, SWT.None, "");
			TableEditor editor = new TableEditor(table);
			editor.grabHorizontal = editor.grabVertical = true;
			TableItem item = new TableItem(table, SWT.BORDER_DASH);
			item.setText(0, "A" + i);
			item.setText(1, "B");
			item.setText(2, "C");
			item.setText(3, "D");
			editor.setEditor(com, item, 3);
		}

		if (count >= 8) {
			data.heightHint = 170;
		}
		table.setLayoutData(data);
		tableCompositeSub.pack();
	}

	private Composite getDialog(Table table) {

		Composite com = new Composite(table, SWT.None);
		com.setLayout(new GridLayout());
		com.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		com.setBackground(new Color(new RGB(255, 255, 255)));
		Label label = new Label(com, SWT.None);
		label.setText("fdsdfsdfsdfsd");
		label.setBackground(new Color(new RGB(255, 255, 0)));

		label.addMouseListener(MouseListener.mouseDownAdapter(e -> {
			label.setBackground(new Color(new RGB(255, 0, 50)));
			TestDialog dis = new TestDialog(Display.getCurrent().getActiveShell().getShell());
			dis.open();
		}));

		return com;
	}

	static class TestDialog extends Dialog {

		public TestDialog(Shell parent) {
			super(parent);
		}

	}

}
