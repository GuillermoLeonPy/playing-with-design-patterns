package py.com.patterns.api.visitorpattern.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import py.com.patterns.api.visitorpattern.bean.Part;
import py.com.patterns.api.visitorpattern.bean.Part.MeasurmentUnit;
import py.com.patterns.api.visitorpattern.bean.impl.CylindricalPart;
import py.com.patterns.api.visitorpattern.bean.impl.CylindricalPart.Shape;
import py.com.patterns.api.visitorpattern.bean.impl.PolyhedralPart;
import py.com.patterns.api.visitorpattern.bean.impl.RootCompositePart;
import py.com.patterns.api.visitorpattern.visitor.Visitor;
import py.com.patterns.api.visitorpattern.visitor.impl.CylindricalPartVisitor;
import py.com.patterns.api.visitorpattern.visitor.impl.PolyhedralPartVisitor;

public class VisitorPatternApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.info("\n ========================="
				+"\n VisitorPatternApplication"
				+"\n =========================");
		
		List<Visitor<?>> visitors = new ArrayList<>();
		visitors.add(new CylindricalPartVisitor());
		visitors.add(new PolyhedralPartVisitor());		
		
		Part part = new CylindricalPart(1, 
				"cylinder", 
				BigDecimal.ONE, 
				BigDecimal.ONE, 
				BigDecimal.ONE, 
				MeasurmentUnit.CENTIMETER, 
				Shape.elliptical, 
				visitors);		
		
		Part part2 = new PolyhedralPart(2, 
				"polyhedral", 
				BigDecimal.ONE, 
				BigDecimal.ONE, 
				BigDecimal.ONE, 
				MeasurmentUnit.CENTIMETER, 
				py.com.patterns.api.visitorpattern.bean.impl.PolyhedralPart.Shape.irregular_cuadrangular_prism, 
				visitors);

		RootCompositePart root = new RootCompositePart(null, null, null, null, null, null, null);
		root.addPart(part);
		root.addPart(part2);
		
		log.info("\n -------------------"
				+"\n part.format:" + part.format()
				+"\n part2.format:" + part2.format()
				+"\n ##############################"
				+"\n root.format:" + root.format()
				+"\n -------------------");
		

		
	}

}
