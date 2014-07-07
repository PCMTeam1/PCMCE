package fr.istic.dugl.pcmce.ui;

import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.client.MesModules;

public class AccueilPCMUi extends VerticalPanel {

	static final int numPage = 0;
	
	private static VerticalPanel HeaderPanel = new VerticalPanel();
	private static VerticalPanel ContentPanel = new VerticalPanel();


	public AccueilPCMUi() {
		
		HeaderPanel.add(MesModules.SAISIR_PCM.getPanel());
		ContentPanel.add(MesModules.DETAIL_PCM.getPanel());
		ContentPanel.setVisible(false);
		
		this.add(HeaderPanel);
		this.add(ContentPanel);
	}


	public static void contentPanel_setVisible(Boolean isVisible) {
		ContentPanel.setVisible(isVisible);
	}
}

