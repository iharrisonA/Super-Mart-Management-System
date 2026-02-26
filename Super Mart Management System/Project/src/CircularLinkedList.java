
public class CircularLinkedList {

CNode head;
int size=0;
	
	public void add(String[] v)    
	{
		CNode nNode=new CNode();
		nNode.value=v;
		nNode.next=null;
		
		if(head==null)  
		{
			head=nNode;
			nNode.next=nNode;
		}
		else
		{
			CNode tNode=head;
			while(tNode.next!=head)   
			{
				tNode=tNode.next;
			}
			tNode.next=nNode;
			nNode.next=head;
		}
		size++;
	}
	
	public void remove(String v)   
	{
		CNode tNode=head;
		CNode pNode=head;
		
		if(head.value[0]==v)    
		{
			head=head.next;
		}
		else
		{
			while(tNode!=null)   
			{
				if(tNode.value[0]==v)
				{
					pNode.next=tNode.next;
					break;
				}
				pNode=tNode;
				tNode=tNode.next;
			}
		}
		size--;
	}
	
	public boolean find(String e)  
	{
		CNode tNode=head;
		while(tNode!=null)
		{
			if(tNode.value[0]==e)
			{
				return true;
			}
			tNode=tNode.next;
		}
		return false;
	}
	
	public double PriceTotal() {
		double sum=0;
		int count=0;
		CNode tNode=head;
		while(tNode!=null)
		{
			if(count<size) {
				sum += Double.parseDouble(tNode.value[2]);
				tNode=tNode.next;
				System.out.println(Double.parseDouble(tNode.value[2]));
				count++;
			}
			else {
				break;
			}
		}
		return sum;
	}
	void display()
	{
		CNode tNode=head;
		do	
		{
			System.out.println(tNode.value[0] + "\t"+tNode.value[1]+"\t"+ tNode.value[2]);
			tNode=tNode.next;
		}
		while(tNode!=head);
		System.out.println("-------------------------------------");
	}
	
}