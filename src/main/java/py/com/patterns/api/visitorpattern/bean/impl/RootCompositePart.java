package py.com.patterns.api.visitorpattern.bean.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import py.com.patterns.api.visitorpattern.bean.Part;
import py.com.patterns.api.visitorpattern.visitor.Visitor;
/**
 * A root part whose purpose is to house sub parts with the objective of get all elements formatted according to their corresponding visitors 
 * @author test-user
 *
 */
public class RootCompositePart extends Part {

	public RootCompositePart(Integer id, String description, BigDecimal height, BigDecimal width, BigDecimal depth,
			MeasurmentUnit measurmentUnit, List<Visitor<?>> visitors) {
		super(id, description, height, width, depth, measurmentUnit, visitors);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, Object> getContentAsMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String format() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(Part subPart:this.subParts) {
			sb.append(subPart.format() + "\n --------------- ");
		}
		return sb.toString();
	}

}
