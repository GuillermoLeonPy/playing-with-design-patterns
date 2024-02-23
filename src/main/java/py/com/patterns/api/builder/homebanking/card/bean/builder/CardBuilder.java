package py.com.patterns.api.builder.homebanking.card.bean.builder;

import py.com.patterns.api.builder.homebanking.card.bean.Card;

public class CardBuilder {
	
	private String number;
	private String paymentOperator;
	
	public CardBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CardBuilder setNumber(String number) {
		this.number = number;
		return this;
	}
	
	public CardBuilder setpaymentOperator(String operator) {
		this.paymentOperator = operator;
		return this;
	}
	
	public Card build() {
		Card card = new Card();
		card.setNumber(number);
		card.setPaymentOperator(paymentOperator);
		return card;
	}
}
