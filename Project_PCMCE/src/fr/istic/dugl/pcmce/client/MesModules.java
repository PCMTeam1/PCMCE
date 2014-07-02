package fr.istic.dugl.pcmce.client;

import com.google.gwt.user.client.ui.VerticalPanel;

public enum MesModules {
	
	SAISIR_PCM(new fr.istic.dugl.pcmce.ui.generateSAISIR_PCM()),
	DETAIL_PCM(new fr.istic.dugl.pcmce.ui.generateDETAIL_PCM());
	
	private VerticalPanel panel;

	private MesModules(VerticalPanel panel) {
		this.panel = panel;
	}
	
	public VerticalPanel getPanel() {
		return panel;
	}
	
}


