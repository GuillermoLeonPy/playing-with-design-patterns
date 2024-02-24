package py.com.patterns.api.decorator.product.combo;

import java.util.function.Consumer;

public class ProductComboDecoratorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product("Internet 60 M", new Product("Bonus Mobile Internet Free", new Product("Hi Bandwidth Extensor Router", new Product("TV Decoder", null))));

		StringBuffer sb = new StringBuffer();
		product.decorate().forEach(new Consumer<ProductFeature>() {

			@Override
			public void accept(ProductFeature t) {
				// TODO Auto-generated method stub
				sb.append("\n" + t.getName());
			}
		});
		
		System.out.println("Product stack: " + sb.toString());
	}

}
