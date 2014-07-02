package fr.istic.dugl.pcmce.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

import fr.istic.dugl.pcmce.ui.AccueilPanel;
 

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Project_PCMCE implements EntryPoint {
	
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	//private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	/*
	private HorizontalPanel  HorizontalPanel = new HorizontalPanel();
	private Button ButtonTest = new Button("test");
	
	static private DeckPanel deckPanel = new DeckPanel();
	*/
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		/*
		AccueilPanel page = (AccueilPanel) Pages.ACCUEIL.getAccueilPanel();
		page.AccueilPanelInit();
		*/
		/*
		IButton button = new IButton("Hello World");
		button.addClickHandler(new ClickHandler() {
							   public void onClick(ClickEvent event) {
							   SC.say("Hello World from SmartGWT");
							   }
							   });
		
		button.draw();
		*/
		
		/*
		final Button sendButton = new Button("Send");
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		
		deckPanel.setVisible(true);
		deckPanel.setSize("1024", "768");
		deckPanel.add(sendButton);
		deckPanel.showWidget(0);
		RootPanel.get("mainDiv").add(deckPanel);
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		
		
		public static void show(Pages page) {
			deckPanel.showWidget(page.ordinal());
		}

		private  void sendNameToServer() {

			 String nom = "AccueilPanel";
			 greetingService.greetServer(nom, new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(String result) {
					AccueilPanel page = (AccueilPanel) Pages.LIST_NOMS.getAccueilPanel();
					// page.init(result);
					page.AccueilPanelInit();
					deckPanel.add(new HTML("<b>"+result+"</b>"));
					Project_PCMCE.show(Pages.LIST_NOMS);
				}
			}); 
		}
		*/
		
	    final DynamicForm form = new DynamicForm();
	    final TextItem textItem = new TextItem();
	    textItem.setTitle("Name");
	    form.setFields(textItem);
	    final IButton button = new IButton("Hello");
	     
	    button.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	            String name = textItem.getValue().toString();
	            SC.say("Hello " + name);
	        }
	    });
	     
	    RootPanel.get("formContainer").add(form);
	    RootPanel.get("buttonContainer").add(button);
	             
	
	}
}
