package handler;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.widgets.Composite;

import handler.demo.GridDataDemo;

public class SamplePart {

	@SuppressWarnings("unused")
	@Inject
	private MPart mpart;

	@PostConstruct
	public void createComposite(Composite parent) {
		// fill demo
		GridDataDemo demo = new GridDataDemo();
		demo.renderPart(parent);
	}

}
