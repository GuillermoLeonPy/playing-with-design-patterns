package py.com.patterns.api.visitorpattern.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import py.com.patterns.api.visitorpattern.visitor.Visitor;

public abstract class Part {
	
	public enum MeasurmentUnit{
		MILIMETER,
		CENTIMETER,
		DECIMETER,
		METER
	}
	
	protected final Integer id;
	protected final String description;
	protected final BigDecimal height;
	protected final BigDecimal width;
	protected final BigDecimal depth;
	protected final MeasurmentUnit measurmentUnit;
	protected final List<Part> subParts;
	protected final Map<String,Object> data;
	protected final List<Visitor<?>> visitors;
	
	public Part(Integer id, String description, BigDecimal height, BigDecimal width, BigDecimal depth, MeasurmentUnit measurmentUnit, List<Visitor<?>> visitors) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.description = description;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.measurmentUnit = measurmentUnit;
		this.subParts = new ArrayList<>();
		this.data = new HashMap<>();
		this.visitors = visitors;
	}
	
	public void addPart(Part part) {
		this.subParts.add(part);
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public BigDecimal getDepth() {
		return depth;
	}

	public MeasurmentUnit getMeasurmentUnit() {
		return measurmentUnit;
	}

	public List<Part> getSubParts() {
		return subParts;
	}
	
	public abstract Map<String,Object> getContentAsMap();
	/**
	 * represents the accept method in the visitor pattern
	 * Its purpose is to get the class properties in a specific format; json, xml, etc..
	 * 
	 * The method does not receive the in instance of the visitor because this class will be a member of a hierarchy
	 * of classes an every class will have its own visitor.
	 * 
	 * An abstract class has been declared at the top if the hierarchy. It has a java.util.List property with the visitor interface,
	 * so any visitor implementation can be added to the list.
	 * 
	 * Then every class check the list for its visitors (there can be more than one). The methodology to identify the corresponding
	 * visitor class is applied with the instanceof operator to the elements of the java.util.List property.
	 * Once the visitor has been identified the class executes the visit method on the visitor
	 * @return
	 */
	public abstract String format();
}
