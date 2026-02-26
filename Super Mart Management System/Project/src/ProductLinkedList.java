
public class ProductLinkedList {
	Node head;
	
	void add(Product v)    
	{
		Node nNode=new Node();
		nNode.value=v;
		nNode.next=null;
		
		if(head==null)  
		{
			head=nNode;
		}
		else
		{
			Node tNode=head;
			while(tNode.next!=null)   
			{
				tNode=tNode.next;
			}
			tNode.next=nNode;
		}
	}
	
	public void remove(int id)   
	{
		Node tNode=head;
		Node pNode=head;
		
		if(head.value.Id==id)    
		{
			head=head.next;
		}
		else
		{
			while(tNode!=null)   
			{
				if(tNode.value.Id==id)
				{
					pNode.next=tNode.next;
					break;
				}
				pNode=tNode;
				tNode=tNode.next;
			}
		}
	}
	
	public boolean find(int id)  
	{
		Node tNode=head;
		while(tNode!=null)
		{
			if(tNode.value.Id==id)
			{
				return true;
			}
			tNode=tNode.next;
		}
		return false;
	}
	public boolean find(String name)  
	{
		Node tNode=head;
		while(tNode!=null)
		{
			if(tNode.value.Name.contains(name))
			{
				return true;
			}
			tNode=tNode.next;
		}
		return false;
	}
	
	void display()
	{
		Node tNode=head;
		while(tNode!=null)
		{
			System.out.println(tNode.value.Id + "\t" + tNode.value.Name);
			tNode=tNode.next;
		}
		System.out.println("--------------------------------------");
	}
}
