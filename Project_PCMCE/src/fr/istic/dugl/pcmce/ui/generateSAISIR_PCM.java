package fr.istic.dugl.pcmce.ui;

import com.google.gwt.user.client.ui.Button;

import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import fr.istic.dugl.pcmce.client.MyClick;

public class generateSAISIR_PCM extends VerticalPanel {
	TextArea OnePCM  = new TextArea();
	Button   viewPCM = new Button("Load");

	public generateSAISIR_PCM () {
		OnePCM.setName("OnePCM");
		this.add(OnePCM);
		viewPCM.addClickHandler(new MyClick(OnePCM));
		this.add(viewPCM);
	}

	public void init(String nom) {
		OnePCM.setText(nom);
	}
}

