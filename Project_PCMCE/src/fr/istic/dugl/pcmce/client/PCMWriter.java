package fr.istic.dugl.pcmce.client;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import pcmmm.PCM;
import pcmmm.PcmmmPackage;

public class PCMWriter {

	//saving a model
	public static void save(PCM myPcmModel, String path) {
		// un peu de quincaillerie pour déclarer le métamodèle auquel on doit être conforme et la sérialisation dans un fichier qui aura une extension en .pcm
		ResourceSet resourceSetMetamodel = new ResourceSetImpl();
		resourceSetMetamodel.getPackageRegistry().put(PcmmmPackage.eNS_URI, PcmmmPackage.eINSTANCE);
		resourceSetMetamodel.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pcm", new XMIResourceFactoryImpl());

		// SAVING THE MODEL
		// la création de la ressource où on va sérialiser (avec l'adresse du fichier : path)
		Resource resourceModel = resourceSetMetamodel.createResource(URI.createFileURI(path));

		// on ajoute le graphe d'objets à sérialiser (la racine pour tout avoir, sinon un autre élément pour avoir un graphe partiel)      
		resourceModel.getContents().add(myPcmModel);
		try {
			// la sérialisation offerte gratuitement par EMF
			resourceModel.save(null);
		} catch (IOException e) {
			System.out.println("error during the model saving step");
			e.printStackTrace();
		}
	}


}