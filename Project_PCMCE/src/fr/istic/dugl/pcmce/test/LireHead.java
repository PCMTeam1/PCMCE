package fr.istic.dugl.pcmce.test;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import com.google.gwt.thirdparty.guava.common.collect.Constraint;

import pcmmm.Cell;
import pcmmm.Matrix;
import pcmmm.PCM;
import pcmmm.ValuedCell;
import pcmmm.VariabilityConcept;
//import fr.istic.dugl.pcmce.PCMReader.CellContentBooleanImplDugl;
import fr.istic.dugl.pcmce.PCMReader.CellContentDoubleImplDUGL;
import fr.istic.dugl.pcmce.PCMReader.CellContentStringImplDUGL;
import fr.istic.dugl.pcmce.PCMReader.CellImplDUGL;
import fr.istic.dugl.pcmce.PCMReader.PCMReader;

public class LireHead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "PCM/Comparison_of_BitTorrent_tracker_software.pcm" ;
		PCM p = new PCMReader().getPCM(fileName);
		// _LOGGER.info("Mon test" + p.getName());

		EList<VariabilityConcept> listConcept = p.getConcepts();
		String trace = "Concepts name : \n";
		for(VariabilityConcept concept : listConcept){
			trace+=concept.getName()+"\n";
			List<ValuedCell> listValuedCell= concept.getConstraints();
			 listValuedCell.contains(trace);
		
			//System.out.println("\nCONSTRAINTS: "+listValuedCell);
			//System.out.println("ValueCell: "+listValuedCell.get(2));
			

			//System.out.println("celluleeee:  "+listValuedCell.get(1));
		}
	

		p.getMatrices();
		/*System.out.println("Matrices : "+p.getMatrices());
		System.out.println("p allcontent: "+p.eAllContents()); // rien
		System.out.println("p allcontent: "+p.eContainer()); // rien*/

		EList<Matrix> listeMatrice = p.getMatrices();
		Matrix maMatrice = listeMatrice.get(0);
		EList<Cell> cells = maMatrice.getCells();
		/*System.out.println("getClass: "+cells.getClass());
		maMatrice.getName();
		System.out.println("matrice: "+maMatrice.eContainingFeature());
		System.out.println("matrice: "+maMatrice.eContainingFeature().getFeatureID());
		
		System.out.println("maMatrice getname: "+maMatrice.getName());
		System.out.println("maMatrice getcells: "+maMatrice.getCells());
		cells.isEmpty();
		System.out.println("cells: "+cells);

		System.out.println("getConcepts"+		p.getConcepts());
		System.out.println("collect "+		p.getDomainCollection());
		System.out.println("getname "+		p.getName());
		System.out.println("PCM desciptor: "+p.getDescription().contains(trace));*/
		
		
		int cellsCounter = 0;
		String verbatim,note,link ="";
		String output = "\n";
		Cell thatCell;
		int column, row, colSpan, rowSpan;
		List maListe;
		int nbColumns = 0, nbRows = 0;

		for (Iterator<Cell> it = cells.iterator(); it.hasNext();){
			thatCell = it.next();
			column = thatCell.getColumn();
			//System.out.println("column: "+column);
			row = thatCell.getRow();
			//System.out.println("row: "+row);
			if(row>nbRows) {nbRows=row;}
			if(column>nbColumns) {nbColumns=column;}
			rowSpan = thatCell.getRowspan();
			colSpan = thatCell.getColspan();
			verbatim = thatCell.getVerbatim();
			System.out.println("------description de la cellule: "+thatCell.getName());
			System.out.println("getVerbatim: "+thatCell.getVerbatim());
			//System.out.println("getName: "+thatCell.eContainingFeature().getName());
			System.out.println("\ngetURIFragment: "+thatCell.eResource().getURIFragment(thatCell));

			System.out.println("\neContents: "+thatCell.eContainer().eContents().get(row).eContents());
			System.out.println("\ncontainer name: "+thatCell.eContainer().eContainmentFeature().getName());
			System.out.println("\ncontainer feature: "+thatCell.eContainer().eContainmentFeature().eContainmentFeature());
			System.out.println("\ncontenu feature: "+thatCell.eContainmentFeature());
			
			//System.out.println("eContainmentFeature: "+thatCell.eContainer().eContainmentFeature());
			
			//System.out.println("\neContents: "+thatCell.eContainmentFeature().getName());
			//System.out.println("getERawType: "+thatCell.eContainingFeature().getEGenericType().getERawType());
			//System.out.println("eDeliver: "+thatCell.eCrossReferences());
			//System.out.println("\nlistIterator: "+thatCell.eContents().listIterator());
			System.out.println("---------------------------------\n\n");
		
			

			output += (//"colSpan : "+ colSpan+"\trowSpan : " + rowSpan+
					"\tcolumn : " + column + "\trow : " + row + "\tcontent : " + verbatim + "\n");
			cellsCounter++;
		}
		

		
	}
	

}
