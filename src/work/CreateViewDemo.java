package work;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class CreateViewDemo {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Snippet 172");
		shell.setSize(533, 550);
		shell.setLocation(2613, 234);

		createRoleGUI(shell);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	protected static void createRoleGUI(Composite parent) {

		parent.setLayout(new GridLayout());
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite composite = new Composite(parent, SWT.NONE);
		GridData gdComposite = new GridData(SWT.FILL, SWT.FILL, true, true);
		composite.setLayoutData(gdComposite);
		composite.setLayout(new GridLayout());

		addTabFolder(composite);
		createGeneralInfoGui();
		createDefinedGui();
		createPrivilegeOptionGui();
		createSqlPreviewGui();

		Composite next = new Composite(composite, SWT.NONE);
		GridData gdComposite2 = new GridData(SWT.RIGHT, SWT.BOTTOM, true, true);
		next.setLayoutData(gdComposite2);
		next.setLayout(new GridLayout(2,false));

		Button but = new Button(next, SWT.None);
		but.setText("下一步");

		Button finish = new Button(next, SWT.None);
		finish.setText("完成");
	}

	static TabFolder tabFolder;

	private static void addTabFolder(Composite composite) {

		tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setData("org.eclipse.swtbot.widget.key", "ID_TABFOLDER_CREATE_URL_TAB_CONTAINER_001");
		// tabFolder.addSelectionListener(new TabFolderSelectionAdapter());

		GridLayout tabLayot = new GridLayout();
		tabLayot.marginBottom = 0;
		tabFolder.setLayout(tabLayot);
		GridData tabFolderCompositeGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		tabFolderCompositeGD.heightHint = 430;
		tabFolder.setLayoutData(tabFolderCompositeGD);

		tabFolder.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int curTab = tabFolder.getSelectionIndex();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	protected static void createGeneralInfoGui() {
		TabItem tbtmStepIndices = new TabItem(tabFolder, SWT.NONE);
		tbtmStepIndices.setData("org.eclipse.swtbot.widget.key", "ID_TABITEM_CREATE_URL_GENERAL_TAB_001");
		tbtmStepIndices.setText("基本信息");
		Composite compositeGeneral = new Composite(tabFolder, SWT.NONE);
		compositeGeneral.setLayout(new GridLayout());
		tbtmStepIndices.setControl(compositeGeneral);
		addUserRolePropertiesUi(compositeGeneral);
		addComments(compositeGeneral);
	}

	protected static void createDefinedGui() {

		TabItem tbtmStepIndices = new TabItem(tabFolder, SWT.NONE);
		tbtmStepIndices.setData("org.eclipse.swtbot.widget.key", "ID_TABITEM_CREATE_URL_GENERAL_TAB_001");
		tbtmStepIndices.setText("定义");
		Composite compositeGeneral = new Composite(tabFolder, SWT.NONE);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		
		compositeGeneral.setLayout(gridLayout);
		compositeGeneral.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		tbtmStepIndices.setControl(compositeGeneral);

		Label label = new Label(compositeGeneral, SWT.None);
		label.setText("选择字段和表");

		TableCreateDemo tableCreateDemo = new TableCreateDemo();
		tableCreateDemo.createTable(compositeGeneral);

		Composite defComposite = new Composite(compositeGeneral, SWT.None);
		defComposite.setLayout(new GridLayout());
		defComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Label def = new Label(defComposite, SWT.None);
		def.setText("定义");

		Composite sourceComposite = new Composite(defComposite, SWT.BORDER);
		sourceComposite.setLayout(new GridLayout());
		sourceComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		sourceComposite.setBackground(new Color(new RGB(255, 255, 0)));

		SourceViewCreater sour = new SourceViewCreater();
		sour.createSqlPreviewGui(sourceComposite);
	}

	private static void addComments(Composite compositeGeneral) {

		Group comOptions = new Group(compositeGeneral, SWT.NONE);
		comOptions.setText("注释（最多5000个字符）");
		comOptions.setLayout(new GridLayout(1, false));
		GridData groupLayoutData = new GridData(SWT.FILL, SWT.TOP, true, false);
		groupLayoutData.heightHint = 165;
		comOptions.setLayoutData(groupLayoutData);

		Text comment = new Text(comOptions, SWT.BORDER);
		comment.setTextLimit(4000);
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
//		gridData.heightHint = 150;
		comment.setLayoutData(gridData);
	}

	private static void addUserRolePropertiesUi(Composite compositeGeneral) {

		Group grpTableProperties = new Group(compositeGeneral, SWT.NONE);
		grpTableProperties.setText("基本信息");
		grpTableProperties.setLayout(new GridLayout(3, false));
		grpTableProperties.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		if (true) {
			Label lblTableName = new Label(grpTableProperties, SWT.LEFT);
			lblTableName.setFont(getFont("Verdana", 9, SWT.None, grpTableProperties.getParent()));
			lblTableName.setText("视图名称");

			GridData textUserRoleNameGridData = new GridData();
			textUserRoleNameGridData.horizontalSpan = 1;
			textUserRoleNameGridData.widthHint = 230;
			Text textUserRoleName = new Text(grpTableProperties, SWT.BORDER);
			textUserRoleName.setLayoutData(textUserRoleNameGridData);

			Composite comp = new Composite(grpTableProperties, SWT.None);
			comp.setLayout(new GridLayout(2, false));
			comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

			Button btnConfirm = new Button(comp, SWT.CHECK);
			Label lblTableName2 = new Label(comp, SWT.LEFT);
			lblTableName2.setFont(getFont("Verdana", 9, SWT.None, grpTableProperties.getParent()));
			lblTableName2.setText("区分大小写");
		}
		if (true) {
			Label lblTableName = new Label(grpTableProperties, SWT.LEFT);
			lblTableName.setFont(getFont("Verdana", 9, SWT.None, grpTableProperties.getParent()));
			lblTableName.setText("所有者");

			GridData textUserRoleNameGridData = new GridData();
			textUserRoleNameGridData.horizontalSpan = 2;
			textUserRoleNameGridData.widthHint = 230;
			Text textUserRoleName = new Text(grpTableProperties, SWT.BORDER);
			textUserRoleName.setLayoutData(textUserRoleNameGridData);
		}
		if (true) {
			Label lblTableName = new Label(grpTableProperties, SWT.LEFT);
			lblTableName.setFont(getFont("Verdana", 9, SWT.None, grpTableProperties.getParent()));
			lblTableName.setText("模式");

			GridData textUserRoleNameGridData = new GridData();
			textUserRoleNameGridData.horizontalSpan = 2;
			textUserRoleNameGridData.widthHint = 230;
			Text textUserRoleName = new Text(grpTableProperties, SWT.BORDER);
			textUserRoleName.setLayoutData(textUserRoleNameGridData);
		}
		if (true) {
			Label lblTableName = new Label(grpTableProperties, SWT.LEFT);
			lblTableName.setFont(getFont("Verdana", 9, SWT.None, grpTableProperties.getParent()));
			lblTableName.setText("视图类型");

			GridData textUserRoleNameGridData = new GridData();
			textUserRoleNameGridData.horizontalSpan = 2;
			textUserRoleNameGridData.widthHint = 230;
			Text textUserRoleName = new Text(grpTableProperties, SWT.BORDER);
			textUserRoleName.setLayoutData(textUserRoleNameGridData);
		}
		if (true) {
			Label lblTableName = new Label(grpTableProperties, SWT.LEFT);
			lblTableName.setFont(getFont("Verdana", 9, SWT.None, grpTableProperties.getParent()));
			lblTableName.setText("设置安全屏障");

			Button btnConfirm = new Button(grpTableProperties, SWT.CHECK);
			GridData textUserRoleNameGridData = new GridData();
			textUserRoleNameGridData.horizontalSpan = 2;
			btnConfirm.setLayoutData(textUserRoleNameGridData);
		}
	}

	public static Font getFont(String name, int height, int style, Composite parent) {
		ResourceManager resManager = new LocalResourceManager(JFaceResources.getResources(), parent);
		Font font = resManager.createFont(FontDescriptor.createFrom(name, height, style));
		return font;
	}

	protected static void createPrivilegeOptionGui() {

		TabItem tbtmStepColumns = new TabItem(tabFolder, SWT.NONE);
		tbtmStepColumns.setText("权限");
		Composite compositePrivilege = new Composite(tabFolder, SWT.NONE);
		GridLayout compGrid = new GridLayout();
		compositePrivilege.setLayout(compGrid);
		tbtmStepColumns.setControl(compositePrivilege);

		TableCreateDemo tableCreateDemo = new TableCreateDemo();
		tableCreateDemo.createTable(compositePrivilege);
	}

	protected static void createSqlPreviewGui() {

		TabItem tbtmStepColumns = new TabItem(tabFolder, SWT.NONE);
		tbtmStepColumns.setData("org.eclipse.swtbot.widget.key", "ID_TABITEM_CREATE_URL_PRIVILEGE_TAB_001");
		tbtmStepColumns.setText("SQL预览");
		Composite compositeSql = new Composite(tabFolder, SWT.NONE);
		GridLayout compGrid = new GridLayout();
		compositeSql.setLayout(compGrid);
		compositeSql.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tbtmStepColumns.setControl(compositeSql);

		SourceViewCreater sour = new SourceViewCreater();
		sour.createSqlPreviewGui(compositeSql);
	}

	private static AnnotationRulerColumn annotationRuler() {

		AnnotationRulerColumn fAnnotationRuler = new AnnotationRulerColumn(new AnnotationModel(), 16,
				getAnnotationAccess());
//        for (AnnotationType annotationType: AnnotationType.values()) {
//            fAnnotationRuler.addAnnotationType(annotationType.getStrategy());
//        }
		return fAnnotationRuler;
	}

	private static IAnnotationAccess getAnnotationAccess() {
		return new PLAnnotationMarkerAccess();
	}

}
