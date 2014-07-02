package fr.istic.dugl.pcmce.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.client.ui.TextArea;

public class MyClick implements ClickHandler {

	TextArea myTextArea;

	public MyClick(TextArea myTextArea) {
		super();
		this.myTextArea = myTextArea;
	}

	@Override
	public void onClick(ClickEvent event) {

		if (myTextArea.getName().equals("OnePCM")){
			Project_PCMCE.generateDETAIL_PCM(myTextArea.getValue());
		}
	}
}