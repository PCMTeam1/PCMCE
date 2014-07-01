package fr.istic.dugl.pcmce.client;

import com.smartgwt.client.widgets.layout.HLayout;

public enum Pages {

	ACCUEIL(new fr.istic.dugl.pcmce.ui.AccueilPanel());
	//LIST_PCM(new fr.istic.dugl.pcmce.ui.PCMPanel());
	
	private HLayout AccueilPanel;

	private Pages(HLayout AccueilPanel) {
		this.AccueilPanel = AccueilPanel;
	}
	
	public HLayout getAccueilPanel() {
		return AccueilPanel;
	}

}
