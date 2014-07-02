package fr.istic.dugl.pcmce.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import fr.istic.dugl.pcmce.PCMReader.PCMReader;
import pcmmm.Cell;
import pcmmm.Constraint;
import pcmmm.Matrix;
import pcmmm.Multiple;
import pcmmm.PCM;
import pcmmm.Partial;
import pcmmm.ValuedCell;
import pcmmm.impl.HeaderImpl;

public class LireCell {

	public static void main(String[] args) {
		
	
		String fileName = "PCM/Comparison.pcm" ;

		String trace="";
		int count = 0;
		PCM p = new PCMReader().getPCM(fileName);
		trace += "<html><body>";

		for(Matrix matrice : p.getMatrices()){
			trace +=  " Matrice : " + count++ +"  "+ matrice.getName()+"\t";

			trace+="<table border='1'>\n";
			for(Cell cell : matrice.getCells()){

				System.out.println("Row: "+cell.getRow());
				cell.getColumn();
				cell.getVerbatim();
				//System.out.println("getmodifier: "+cell.getClass().getModifiers());
				System.out.println("simplename: "+cell.getClass().getSimpleName());
				//System.out.println("componentType: "+cell.getClass().getComponentType()); // toujours à null
				System.out.println("methods: "+cell.getClass().getDeclaredMethods()); 
				System.out.println("filename: "+fileName);
				if (cell.getClass().getSimpleName() != null  )
				{
					System.out.println("true");
				}
				
				if(cell instanceof ValuedCell){
					ValuedCell valuedCell=(ValuedCell)cell;
					System.out.println("interpretation: "+valuedCell.getInterpretation().getClass().getSimpleName());
					if(valuedCell.getInterpretation() instanceof Partial){
						((Partial)valuedCell.getInterpretation()).getArgument().getClass().getSimpleName();

						Constraint condition = ((Partial)valuedCell.getInterpretation()).getCondition();
						condition.getClass().getSimpleName();

						/*if(condition instanceof Multiple){
							
							trace+=outputMultipleConstraint((Multiple)condition);
							
						}

						trace+="</td>";*/
					}
					/*if(valuedCell.getInterpretation() instanceof Multiple){
						trace+=outputMultipleConstraint((Multiple)valuedCell.getInterpretation());
					}*/
				}
				// faire les tests ici
				cell.getName();
				cell.getClass().getSimpleName();
			}
			trace+="</tr>";

		}

		trace+="\n</table><br/>";

		trace+="</body></html>";
		

		/*try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("TestTypesComparison_of_code_generation_tools.pcm.html")));

			out.write(trace);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		//_LOGGER.info(trace);
	}

}
