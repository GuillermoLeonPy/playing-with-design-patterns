package py.com.patterns.api.builder.homebanking;

import py.com.patterns.api.builder.homebanking.account.bean.CheckingAccount;
import py.com.patterns.api.builder.homebanking.account.bean.SavingsAccount;
import py.com.patterns.api.builder.homebanking.account.bean.builder.CheckingAccountBuilder;
import py.com.patterns.api.builder.homebanking.account.bean.builder.SavingsAccountBuilder;
import py.com.patterns.api.builder.homebanking.card.bean.builder.CardBuilder;
import py.com.patterns.api.builder.homebanking.currency.bean.Currency;
import py.com.patterns.api.builder.homebanking.liable.bean.builder.PhysicalPersonBuilder;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SavingsAccount savingsAccount = new SavingsAccountBuilder().
									addCreditCard(new CardBuilder().setNumber("").setpaymentOperator("").build())
									.addCurrency(new Currency())
									.addMainHolder(new PhysicalPersonBuilder().addIdentifyingData("CI", "").addIdentifyingData("firstName", "").build())
									.addDeputyHolder(new PhysicalPersonBuilder().addIdentifyingData("CI", "").addIdentifyingData("firstName", "").build())
									.addWithdrawalCards(new CardBuilder().setNumber("").setpaymentOperator("").build())
									.build();
		
		CheckingAccount checkingAccount = new CheckingAccountBuilder()
									.addCreditCard(new CardBuilder().setNumber("").setpaymentOperator("").build())
									.addCurrency(new Currency())
									.addMainHolder(new PhysicalPersonBuilder().addIdentifyingData("CI", "").addIdentifyingData("firstName", "").build())
									.addDeputyHolder(new PhysicalPersonBuilder().addIdentifyingData("CI", "").addIdentifyingData("firstName", "").build())
									.addWithdrawalCards(new CardBuilder().setNumber("").setpaymentOperator("").build())
									.build();
		
	}

}
