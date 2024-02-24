package py.com.patterns.api.decorator.product.combo;

public class ProductComboDecoratorApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product("Internet 60 M", new Product("Bonus Mobile Internet Free", new Product("Hi Bandwidth Extensor Router", new Product("TV Decoder", null))));

		StringBuffer sb = new StringBuffer();
		
		product.decorate().forEach(p -> sb.append("\n" + p.getName()));
		
		System.out.println("Product stack: " + sb.toString());
	}

}
