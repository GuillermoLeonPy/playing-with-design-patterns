package py.com.patterns.api.builder.homebanking.liable.bean.builder;

import py.com.patterns.api.builder.homebanking.liable.bean.PhysicalPerson;

public class PhysicalPersonBuilder extends LiableBuilder<PhysicalPerson> {

	@Override
	public PhysicalPerson build() {
		// TODO Auto-generated method stub
		PhysicalPerson person = new PhysicalPerson();
		person.completeCommercialReferenceData(this.commercialReferenceData);
		person.completeIdentifyingData(this.identifyingData);
		person.completeResidenceData(this.residenceData);
		return person;
	}

}
