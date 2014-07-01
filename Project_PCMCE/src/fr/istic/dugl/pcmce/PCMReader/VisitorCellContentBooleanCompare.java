package fr.istic.dugl.pcmce.PCMReader;

import sun.reflect.generics.tree.ArrayTypeSignature;
import sun.reflect.generics.tree.BooleanSignature;
import sun.reflect.generics.tree.BottomSignature;
import sun.reflect.generics.tree.ByteSignature;
import sun.reflect.generics.tree.CharSignature;
import sun.reflect.generics.tree.ClassSignature;
import sun.reflect.generics.tree.ClassTypeSignature;
import sun.reflect.generics.tree.DoubleSignature;
import sun.reflect.generics.tree.FloatSignature;
import sun.reflect.generics.tree.FormalTypeParameter;
import sun.reflect.generics.tree.IntSignature;
import sun.reflect.generics.tree.LongSignature;
import sun.reflect.generics.tree.MethodTypeSignature;
import sun.reflect.generics.tree.ShortSignature;
import sun.reflect.generics.tree.SimpleClassTypeSignature;
import sun.reflect.generics.tree.TypeVariableSignature;
import sun.reflect.generics.tree.VoidDescriptor;
import sun.reflect.generics.tree.Wildcard;

/**
 * Visitor (processing) 
 * @author Yves Mocquard 
 *
 */
public class VisitorCellContentBooleanCompare implements IVisitorCellContent {
	
	private ICellContentBoolean b;
	
	public VisitorCellContentBooleanCompare( ICellContentBoolean b )
	{
		this.b = b;
	}

	public int compareToCellContentString( ICellContentString a )
	{
		return 1;
	}
	
	public int compareToCellContentBoolean( ICellContentBoolean a )
	{
		return 1;
	}
	public int compareToCellContentComposite( ICellContentComposite a )
	{
		return 1;
	}
	
	public int compareToCellContentDouble( ICellContentDouble a )
	{
		return 1;
	}
	
	public int compareToCellContentInteger( ICellContentInteger a )
	{
		return 1;
	}




}
