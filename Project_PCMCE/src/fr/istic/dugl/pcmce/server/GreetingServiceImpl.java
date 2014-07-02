package fr.istic.dugl.pcmce.server;

import fr.istic.dugl.pcmce.client.GreetingService;
import fr.istic.dugl.pcmce.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {

		return input;
		
	}
}
