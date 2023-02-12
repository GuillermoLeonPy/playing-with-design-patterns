package py.com.patterns.api.compositepattern.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPart implements Part {

	protected Map<String,Object> data;
	protected List<Part> parts;
	
	public AbstractPart() {
		// TODO Auto-generated constructor stub
		data = new HashMap<String,Object>();
		parts = new ArrayList<>();
	}

	@Override
	public Object getDataById(String dataId) {
		// TODO Auto-generated method stub
		return data.get(dataId);
	}

	@Override
	public void addData(String dataId, Object dataValue) {
		// TODO Auto-generated method stub
		data.put(dataId, dataValue);
	}

	@Override
	public Map<String, Object> getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public List<Part> getParts() {
		// TODO Auto-generated method stub
		return parts;
	}

	@Override
	public void addPart(Part part) {
		parts.add(part);
		
	}

}
