package handler.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import handler.IPartDemoInf;

public class LabelTestDemo implements IPartDemoInf{

	@Override
	public void renderPart(Composite parent) {
		Label lable = new Label(parent,SWT.WRAP);
		lable.setText("Hello,Zola.");
	}

}
