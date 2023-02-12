package py.com.patterns.api.compositepattern.bean;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMachine {

	protected List<Part> parts;
	
	public AbstractMachine() {
		// TODO Auto-generated constructor stub
		parts = new ArrayList<>();
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
}
