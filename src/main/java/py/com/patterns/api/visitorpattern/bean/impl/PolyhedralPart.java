package py.com.patterns.api.visitorpattern.bean.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import py.com.patterns.api.visitorpattern.bean.Part;
import py.com.patterns.api.visitorpattern.visitor.Visitor;
import py.com.patterns.api.visitorpattern.visitor.impl.PolyhedralPartVisitor;

public class PolyhedralPart extends Part {

	public enum Shape{
		regular_cubic,
		regular_tetrahedric,
		regular_octaedric,
		irregular_triangular_prism,
		irregular_cuadrangular_prism
	}
	
	protected final Shape shape;
	
	public PolyhedralPart(Integer id, String description, BigDecimal height, BigDecimal width, BigDecimal depth,
			MeasurmentUnit measurmentUnit, Shape shape, List<Visitor<?>> visitors) {
		super(id, description, height, width, depth, measurmentUnit, visitors);
		this.shape = shape;
		// TODO Auto-generated constructor stub
	}	

	public Shape getShape() {
		return shape;
	}

	@Override
	public Map<String, Object> getContentAsMap() {
		// TODO Auto-generated method stub
		this.data.put("ID", this.id);
		this.data.put("DESCRIPTION", this.description);
		this.data.put("HEIGHT", this.height);
		this.data.put("WIDTH", this.width);
		this.data.put("DEPTH", this.depth);
		this.data.put("MEASURMENT_UNIT", this.measurmentUnit.toString());
		this.data.put("SHAPE", this.shape.toString());
		return this.data;
	}

	@Override
	public String format() {
		// TODO Auto-generated method stub
		for(Visitor<?> visitor: this.visitors) {
			if(visitor instanceof PolyhedralPartVisitor) {				
				return ((PolyhedralPartVisitor)visitor).visit(this);
			}
		}
		return null;
	}

}
