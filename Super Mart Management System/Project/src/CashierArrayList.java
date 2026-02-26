
public class CashierArrayList {

	Cashier data[];
	int size;
	
	CashierArrayList()
	{
		this(2);
	}
	
	public CashierArrayList(int i) {
		if(i>0)
		{
			data = (Cashier[]) new Cashier[i];
		}
		else if(i==0)
		{
			data = (Cashier[]) new Cashier[0];
		}
		else
		{
			System.out.println("size cannot be negative");
		}
		
		
	}
	
	public void ensurecapactity()
	{       
		if(data.length<=size)
		{
			int oldcap=data.length;  
			int newcap=oldcap+oldcap/2; 
			
			Cashier temp[] = (Cashier[]) new Cashier[newcap];  
			for (int i = 0; i < data.length; i++) {
				temp[i]=data[i];    
									
			}
			
			data=temp;
		}
	}
	
	public void add(Cashier value)
	{
		ensurecapactity();
		data[size]=value;    
		size++;              
	}

	public Cashier remove(int index)      
	{
		if(index > size || index < 0)
		{
			throw new ArrayIndexOutOfBoundsException("Crossing size limit");
		}
	 
		
		Cashier temp=data[index];        
		for (int i = index; i < data.length-1; i++) {
			data[i]=data[i+1];
		}
		size--;
		data[size]=null;
		
		return temp;
	}

	public int indexof(Cashier o)
	{
		if(o==null)
		{
			return -1;
		}
		else
		{
			for (int i = 0; i < size; i++) {
				if(data[i]==o)
				{
					return i;
				}
			}
		}
		return -1;
	}
	public int indexof(String id)
	{
		if(id==null)
		{
			return -1;
		}
		else
		{
			for (int i = 0; i < size; i++) {
				if(data[i].Id==id)
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean contains(Cashier value)
	{
		if(indexof(value)!=-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Cashier get(int index)
	{
		if(index > size || index < 0)
		{
			throw new ArrayIndexOutOfBoundsException("Crossing size limit");
		}
		return data[index];
	}
	
	         
	public void add(int index, Cashier value)
	{
		if(index > size || index < 0)
		{
			throw new ArrayIndexOutOfBoundsException("Crossing size limit");
		}
		ensurecapactity();
		Cashier temp=data[size-1];
		                             
		for (int i = size-1; i >= index; i--) {
			data[i+1]=data[i];
		}
		data[index]=value;
		size++;
	}
	
	public void display()
	{
		for (int i = 0; i < size; i++) {
			System.out.println(data[i].Id +" - "+data[i].Name+ ", ");
		}
		System.out.println("--------------------------------------");
	}
}
