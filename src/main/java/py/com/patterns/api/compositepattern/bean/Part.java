package py.com.patterns.api.compositepattern.bean;

import java.util.List;
import java.util.Map;

public interface Part {

	public String PART_TYPE_DATA_ID = "PART_TYPE_ID";
	public String PART_TYPE_ELECTRONIC = "ELECTRONIC";
	public String PART_TYPE_FLUID = "FLUID";
	public String PART_TYPE_MECHANIC = "MECHANIC";
	public String PART_TYPE_SOFTWARE = "SOFTWARE";
	
	Object getDataById(String dataId);
	void addData(String dataId, Object dataValue);
	Map<String,Object> getData();
	List<Part> getParts();
	void addPart(Part part);
}
