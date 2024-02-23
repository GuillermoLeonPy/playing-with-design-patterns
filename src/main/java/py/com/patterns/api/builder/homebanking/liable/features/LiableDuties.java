package py.com.patterns.api.builder.homebanking.liable.features;

import java.util.Map;

public interface LiableDuties {
	void completeIdentifyingData(Map<String,String> data);
	void completeResidenceData(Map<String,String> data);
	void completeCommercialReferenceData(Map<String,String> data);
}
