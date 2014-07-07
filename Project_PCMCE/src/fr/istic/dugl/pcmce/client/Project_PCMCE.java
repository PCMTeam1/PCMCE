package fr.istic.dugl.pcmce.client;

import java.util.Collection;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.client.MesPages;
import fr.istic.dugl.pcmce.client.SuccesServiceAsync;
import fr.istic.dugl.pcmce.client.SuccesService;
import fr.istic.dugl.pcmce.ui.AccueilPCMUi;
import fr.istic.dugl.pcmce.ui.DetailPCMUi;
import fr.istic.dugl.pcmce.ui.SaisirPCMUi;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Project_PCMCE implements EntryPoint {

	private final static SuccesServiceAsync succesService = GWT.create(SuccesService.class);
	static private DeckPanel deckPanel = new DeckPanel();
		
	@Override
	public void onModuleLoad() {
		RootPanel.get("Project_PCMCE").add(deckPanel);
		deckPanel.addStyleName("deckpanelSn");
		deckPanel.add(MesPages.ACCUEIL_PCM.getPanel());
		
		deckPanel.showWidget(0); // Accueil
		// Project_PCMCE.show(MesPages.ACCUEIL_PCM);
		// generateSAISIR_PCM();
	}

	/*
	public static void show(MesPages page) {
		deckPanel.showWidget(page.ordinal());
	}
	*/
	public static void show(String Panel) {
		AccueilPCMUi.contentPanel_setVisible(true);
	}
	
	public static SuccesServiceAsync getSuccesservice() {
		return succesService;
	}
}
