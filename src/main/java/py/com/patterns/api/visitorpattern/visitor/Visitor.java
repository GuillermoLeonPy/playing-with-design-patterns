package py.com.patterns.api.visitorpattern.visitor;

public interface Visitor<T> {
	String visit(T part);
}
