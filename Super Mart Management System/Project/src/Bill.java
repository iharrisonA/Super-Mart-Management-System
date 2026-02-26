import java.util.List;

public class Bill {

	public int BillNo;
	public String CustomerName;
	public java.util.Date Date;
	public List<Product> Product;

	public Bill() {
		this.BillNo = (int) (Math.random() * (999 + 1 - 001)) + 001;
		this.Date = new java.util.Date();
	}
}
