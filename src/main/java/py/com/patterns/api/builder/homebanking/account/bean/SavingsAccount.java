package py.com.patterns.api.builder.homebanking.account.bean;

import py.com.patterns.api.builder.homebanking.account.features.AccountFeatures;
import py.com.patterns.api.builder.homebanking.card.features.CardInformation;
import py.com.patterns.api.builder.homebanking.currency.features.CurrencyInformation;
import py.com.patterns.api.builder.homebanking.liable.features.LiableInformation;

public class SavingsAccount implements AccountFeatures {

	@Override
	public void setMainHolder(LiableInformation mainHolder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCurrency(CurrencyInformation currency) {
		// TODO Auto-generated method stub

	}

	@Override
	public void associateWithdrawalCard(CardInformation card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void associateCreditCard(CardInformation card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDeputyHolders(LiableInformation deputyHolder) {
		// TODO Auto-generated method stub
		
	}

}
