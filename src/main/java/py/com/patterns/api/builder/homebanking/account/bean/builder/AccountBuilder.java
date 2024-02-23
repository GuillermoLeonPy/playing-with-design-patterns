package py.com.patterns.api.builder.homebanking.account.bean.builder;

import java.util.ArrayList;
import java.util.List;
import py.com.patterns.api.builder.homebanking.card.features.CardInformation;
import py.com.patterns.api.builder.homebanking.currency.features.CurrencyInformation;
import py.com.patterns.api.builder.homebanking.liable.features.LiableInformation;

public abstract class AccountBuilder<T> {
	
	protected LiableInformation mainHolder;
	protected List<LiableInformation> deputyHolders;
	protected CurrencyInformation currency;
	protected List<CardInformation> withdrawalCards;
	protected List<CardInformation> creditCards;
	

	public AccountBuilder() {
		super();
		// TODO Auto-generated constructor stub
		this.deputyHolders = new ArrayList<>(); 
		this.withdrawalCards = new ArrayList<>();
		this.creditCards = new ArrayList<>();
	}
	
	public AccountBuilder<T> addMainHolder(LiableInformation mainHolder) {
		this.mainHolder = mainHolder;
		return this;
	}
	
	public AccountBuilder<T> addDeputyHolder(LiableInformation deputyHolder) {
		this.deputyHolders.add(deputyHolder);
		return this;
	}
	
	public AccountBuilder<T> addCurrency(CurrencyInformation currency) {
		this.currency = currency;
		return this;
	}
	
	public AccountBuilder<T> addWithdrawalCards(CardInformation withdrawalCard) {
		this.withdrawalCards.add(withdrawalCard);
		return this;
	}
	
	public AccountBuilder<T> addCreditCard(CardInformation creditCard) {
		this.creditCards.add(creditCard);
		return this;
	}
	
	public abstract T build();
}
