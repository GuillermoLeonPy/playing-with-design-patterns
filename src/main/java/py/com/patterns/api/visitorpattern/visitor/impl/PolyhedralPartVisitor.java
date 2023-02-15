package py.com.patterns.api.visitorpattern.visitor.impl;

import py.com.patterns.api.visitorpattern.bean.impl.PolyhedralPart;
import py.com.patterns.api.visitorpattern.visitor.Visitor;

public class PolyhedralPartVisitor implements Visitor<PolyhedralPart> {

	public PolyhedralPartVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String visit(PolyhedralPart part) {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();		
		part.getContentAsMap().keySet().forEach(k -> {
			sb.append("\n " + k + ":" + part.getContentAsMap().get(k).toString());
		});
		return sb.toString();
	}

}
