package fr.istic.dugl.pcmce.client;

import com.google.gwt.user.client.ui.VerticalPanel;

public enum MesPages {
	
	ACCUEIL_PCM(new fr.istic.dugl.pcmce.ui.AccueilPCMUi());
	
	private VerticalPanel panel;

	private MesPages(VerticalPanel panel) {
		this.panel = panel;
	}
	
	public VerticalPanel getPanel() {
		return panel;
	}
	

}
