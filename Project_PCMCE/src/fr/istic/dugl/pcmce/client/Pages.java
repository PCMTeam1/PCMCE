package fr.istic.dugl.pcmce.client;

import com.google.gwt.user.client.ui.VerticalPanel;

public enum Pages {

	LIST_NOMS(new fr.istic.dugl.pcmce.ui.AccueilPanel());
	
	private VerticalPanel AccueilPanel;

	private Pages(VerticalPanel Accueil) {
		this.AccueilPanel = Accueil;
	}
	
	public VerticalPanel getAccueilPanel() {
		return AccueilPanel;
	}

}
