package py.com.patterns.api.compositepattern.application;

import java.util.ArrayList;
import java.util.List;

import py.com.patterns.api.compositepattern.bean.AbstractMachine;
import py.com.patterns.api.compositepattern.bean.AbstractPart;
import py.com.patterns.api.compositepattern.bean.Part;
import py.com.patterns.api.compositepattern.bean.impl.Computer;
import py.com.patterns.api.compositepattern.bean.impl.ElectronicPart;
import py.com.patterns.api.compositepattern.bean.impl.FluidPart;
import py.com.patterns.api.compositepattern.bean.impl.MechanicPart;
import py.com.patterns.api.compositepattern.bean.impl.SoftwarePart;

public class CompositePatternApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AbstractMachine machine = new Computer();// -> a composite: has leaf elements - https://www.baeldung.com/java-composite-pattern#composite
		MechanicPart mechanicPart = new MechanicPart();// -> a composite: has leaf elements - https://www.baeldung.com/java-composite-pattern#composite
		mechanicPart.addPart(new FluidPart());
		
		
		ElectronicPart electronicPart = new ElectronicPart();// -> a composite: has leaf elements - https://www.baeldung.com/java-composite-pattern#composite
		electronicPart.addPart(new SoftwarePart());
		
		List<Part> partList = new ArrayList<>();
		
		partList.add(mechanicPart);
		partList.add(electronicPart);
		
		/*just por concept practice*/
		List<AbstractPart> abstractPartList = new ArrayList<>();
		//--> compiler error !!! --The method addAll(Collection<? extends AbstractPart>) in the type List<AbstractPart> 
		//is not applicable for the arguments (List<Part>)
		//abstractPartList.addAll(partList); 
		abstractPartList.add(mechanicPart);
		abstractPartList.add(electronicPart);
		
		machine.setParts(partList);
	}

}
