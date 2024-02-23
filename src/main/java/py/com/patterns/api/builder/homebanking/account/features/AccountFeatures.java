package py.com.patterns.api.builder.homebanking.account.features;
import py.com.patterns.api.builder.homebanking.card.features.CardInformation;
import py.com.patterns.api.builder.homebanking.currency.features.CurrencyInformation;
import py.com.patterns.api.builder.homebanking.liable.features.LiableInformation;

public interface AccountFeatures {

	void setMainHolder(LiableInformation mainHolder);
	void addDeputyHolders(LiableInformation deputyHolder);
	void setCurrency(CurrencyInformation currency);
	void associateWithdrawalCard(CardInformation card);
	void associateCreditCard(CardInformation card);
	
}
