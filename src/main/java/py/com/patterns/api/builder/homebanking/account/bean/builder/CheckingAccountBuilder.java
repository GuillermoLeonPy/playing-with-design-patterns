package py.com.patterns.api.builder.homebanking.account.bean.builder;

import java.util.function.Consumer;

import py.com.patterns.api.builder.homebanking.account.bean.CheckingAccount;
import py.com.patterns.api.builder.homebanking.card.features.CardInformation;
import py.com.patterns.api.builder.homebanking.liable.features.LiableInformation;

public class CheckingAccountBuilder extends AccountBuilder<CheckingAccount> {

	@Override
	public CheckingAccount build() {
		// TODO Auto-generated method stub
		CheckingAccount account = new CheckingAccount();
		this.creditCards.forEach(new Consumer<CardInformation>() {
			@Override
			public void accept(CardInformation card) {
				account.associateCreditCard(card);				
			}
		});
		
		this.withdrawalCards.forEach(new Consumer<CardInformation>() {
			@Override
			public void accept(CardInformation card) {
				account.associateWithdrawalCard(card);				
			}
		});		
		
		this.deputyHolders.forEach(new Consumer<LiableInformation>() {
			@Override
			public void accept(LiableInformation deputyHolder) {
				account.addDeputyHolders(deputyHolder);				
			}
		});	
		return account;
	}

}
