package shop;

public interface GeneralWarehouse {

	public abstract void add(Product product);
	public abstract Product set(Product product);
	public abstract void get(Product product);
	public abstract void remove(Product product);
}
