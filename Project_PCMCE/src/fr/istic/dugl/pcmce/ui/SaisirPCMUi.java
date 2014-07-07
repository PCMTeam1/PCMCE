package fr.istic.dugl.pcmce.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.istic.dugl.pcmce.client.DetailPCMCtrl;
import fr.istic.dugl.pcmce.client.MesModules;
import fr.istic.dugl.pcmce.client.Project_PCMCE;


public class SaisirPCMUi extends VerticalPanel {
	
	static final int numModule = 1;
	
	HorizontalPanel BrowseBar = new HorizontalPanel();
	TextBox OnePCM  = new TextBox();
	ListBox lstPCMs = new ListBox();
	
	Button viewPCM = new Button("Load");
	
	public SaisirPCMUi() {
		init();
	}

	public void init() {
		
		/*
		 * init ui components
		 */
		OnePCM.setName("OnePCM");
		BrowseBar.add(OnePCM);
		BrowseBar.add(lstPCMs);
		BrowseBar.add(viewPCM);	
		this.add(BrowseBar);
		
		//OnePCM.setText(nom);
		viewPCM.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					DetailPCMCtrl.generateDETAIL_PCM(OnePCM.getValue());
					String DetailPCM = "DetailPCM";
					Project_PCMCE.show(DetailPCM);
				}		
			});

	}

}

