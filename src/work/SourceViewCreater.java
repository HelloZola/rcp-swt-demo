package work;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class SourceViewCreater {

	protected  void createSqlPreviewGui(Composite compositeSql) {

		ISharedTextColors sharedColors = new SharedTextColors();
		IOverviewRuler overviewRuler = new OverviewRuler(new PLAnnotationMarkerAccess(), 12, sharedColors);

		SourceViewer projectdViewer = new ProjectionViewer(compositeSql, getCompositeRuler(), null, true,
				SWT.MULTI | SWT.BORDER);
		projectdViewer.setDocument(new Document(""));
		projectdViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}
	
	private static CompositeRuler getCompositeRuler() {

		int annotationRulerColumnIndex = 0;
		int lineNumberColumnIndex = 1;

		CompositeRuler fCompositeRuler = new CompositeRuler(0);
//        AnnotationRulerColumn annotationRulerCol = getAnnotationRulerColumn();
//		fCompositeRuler.addDecorator(0, annotationRulerCol);

		LineNumberRulerColumn lineNumRulerColumn = new LineNumberRulerColumn();
		lineNumRulerColumn.setForeground(new Color(Display.getDefault(), 104, 99, 94));

		fCompositeRuler.addDecorator(lineNumberColumnIndex, lineNumRulerColumn);

//		AnnotationModel fAnnotationModel = new AnnotationModel();
//		fCompositeRuler.setModel(fAnnotationModel);

		return fCompositeRuler;
	}
	
}
