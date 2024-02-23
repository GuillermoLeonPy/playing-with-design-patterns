package py.com.patterns.api.builder.homebanking.liable.features;

import java.util.Map;

public interface LiableInformation {

	Map<String,String> getIdentifyingData();
	Map<String,String> getResidenceData();
	Map<String,String> getCommercialReferenceData();
}
