package fr.istic.dugl.pcmce.client;

import com.google.gwt.user.client.ui.VerticalPanel;

public enum MesModules {
	
	SAISIR_PCM(new fr.istic.dugl.pcmce.ui.SaisirPCMUi()),
	DETAIL_PCM(new fr.istic.dugl.pcmce.ui.DetailPCMUi());
	
	private VerticalPanel panel;

	private MesModules(VerticalPanel panel) {
		this.panel = panel;
	}
	
	public VerticalPanel getPanel() {
		return panel;
	}
	
	public void setVisible(Boolean isVisible){
		panel.setVisible(isVisible);
	}
	
}


