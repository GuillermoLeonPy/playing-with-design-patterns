package py.com.patterns.api.builder.homebanking.liable.bean;

import java.util.Map;

import py.com.patterns.api.builder.homebanking.liable.features.LiableDuties;
import py.com.patterns.api.builder.homebanking.liable.features.LiableInformation;

public class PhysicalPerson implements LiableDuties, LiableInformation {

	@Override
	public void completeIdentifyingData(Map<String,String> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void completeResidenceData(Map<String,String> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void completeCommercialReferenceData(Map<String,String> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String,String> getIdentifyingData() {
		// TODO Auto-generated method stub
		return null;		
	}

	@Override
	public Map<String,String> getResidenceData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,String> getCommercialReferenceData() {
		// TODO Auto-generated method stub
		return null;
	}

}
