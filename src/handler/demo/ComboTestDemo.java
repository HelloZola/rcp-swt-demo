package handler.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import handler.IPartDemoInf;

public class ComboTestDemo implements IPartDemoInf {

	@Override
	public void renderPart(Composite parent) {
		Combo combo = new Combo(parent, SWT.NULL);
		String[] languages = new String[] { "Java", "C", "C++", "SmallTalk" };
		for (String lan : languages) {
			combo.add(lan);
		}
	}
}
