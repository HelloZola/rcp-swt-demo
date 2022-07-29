package handler;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import handler.demo.ComboTestDemo;

public class SamplePart {

	@SuppressWarnings("unused")
	@Inject
	private MPart mpart;
	
	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1,false));
		
		//fill demo
		ComboTestDemo demo = new ComboTestDemo();
		demo.renderPart(parent);
	}
	
}
