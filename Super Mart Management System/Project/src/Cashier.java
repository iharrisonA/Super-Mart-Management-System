import java.util.Date;

public class Cashier extends User{
	public Date LoginTime;
	public Date LogoutTime;
	
	public Cashier() {
		Id = (int) (Math.random() * (99999 + 1 - 00001)) + 00001+"";
	}
	
	public Cashier(String id, String name, String email, String phone, String add) {
		this.Id = id;
		this.Name = name;
		this.Email = email;
		this.Phone = phone;
		this.Address = add;
	}
}
