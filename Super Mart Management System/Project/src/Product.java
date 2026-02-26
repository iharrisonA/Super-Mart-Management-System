
public class Product {
	
	enum SampleProducts{
		Rice, Pulses, Biscuit, Soap, Shampoo
	}
	
	public int Id;
	public String Name;
	public String Quantity;
	public double Price;
	public String Description;

	public Product() {
		Id = (int) (Math.random() * (99999 + 1 - 00001)) + 00001;
	}
	public Product(String name, double price) {
		Id = (int) (Math.random() * (99999 + 1 - 00001)) + 00001;
		this.Name = name;
		this.Price = price;
	}
	public Product(int id, String name, String quantity, double price, String desc) {
		this.Id = id;
		this.Name = name;
		this.Quantity = quantity;
		this.Price = price;
		this.Description = desc;
	}
}
