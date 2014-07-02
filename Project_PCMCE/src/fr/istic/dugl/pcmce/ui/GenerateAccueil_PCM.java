package fr.istic.dugl.pcmce.ui;

import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.client.MesModules;

public class GenerateAccueil_PCM extends VerticalPanel {
	
	VerticalPanel HeaderPanel = new VerticalPanel();
	VerticalPanel ContentPanel = new VerticalPanel();

	public GenerateAccueil_PCM() {
		
		HeaderPanel.add(MesModules.SAISIR_PCM.getPanel());
		ContentPanel.add(MesModules.DETAIL_PCM.getPanel());
		ContentPanel.setVisible(false);
		
		this.add(HeaderPanel);
		this.add(ContentPanel);
	}
}

