package py.com.patterns.api.visitorpattern.visitor.impl;

import py.com.patterns.api.visitorpattern.bean.impl.CylindricalPart;
import py.com.patterns.api.visitorpattern.visitor.Visitor;

public class CylindricalPartVisitor implements Visitor<CylindricalPart> {

	public CylindricalPartVisitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String visit(CylindricalPart part) {
		// TODO Auto-generated method stub
		final StringBuilder sb = new StringBuilder();		
		part.getContentAsMap().keySet().forEach(k -> {
			sb.append("\n " + k + ":" + part.getContentAsMap().get(k).toString());
		});
		return sb.toString();
	}

}
