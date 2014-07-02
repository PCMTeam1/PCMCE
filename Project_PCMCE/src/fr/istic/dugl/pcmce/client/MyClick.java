package fr.istic.dugl.pcmce.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextArea;
import fr.istic.dugl.pcmce.client.DetailPCMCtrl;

public class MyClick implements ClickHandler {

	TextArea myTextArea;

	public MyClick(TextArea myTextArea) {
		super();
		this.myTextArea = myTextArea;
	}

	@Override
	public void onClick(ClickEvent event) {
		
		
		
		DetailPCMCtrl.generateDETAIL_PCM(myTextArea.getValue());
	}
}