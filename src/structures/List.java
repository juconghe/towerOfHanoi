package structures;

public class List<T> implements ListInterface<T> {
	
	private int size;
	private CircularNode head;
	private CircularNode tail;
	
	public List()
	{
		head=null;
		tail=head;
		size=0;		
	}
	/**
	 * Returns the number of elements in this {@link ListInterface}. The running
	 * time of this method must be O(1).
	 * 
	 * @return the number of elements in this {@link ListInterface}
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Appends an element to the end of this {@link ListInterface}. For
	 * convenience, this method returns the appended {@link ListInterface}. The
	 * running time of this method must be O(1).
	 * 
	 * @param elem
	 *            the element to append
	 * @return the appended {@link ListInterface}.
	 * @throws {@code NullPointerException} if {@code elem} is {@code null}
	 */
	public ListInterface<T> append(T elem)
	{
		List<T> list = this;
		
		if(elem==null)
			throw new NullPointerException();
		else
		{
		if(head==null)
		{
			head=new CircularNode(elem);
			tail=head;
			size++;
			return list;
		}
		else
		{
			tail.setLink(new CircularNode(elem));
			tail=tail.getLink();
			size++;
			return list;
		}
		}
	}

	/**
	 * Removes the {@code n}th element in this {@link ListInterface} and returns
	 * it. If {@code n} is not in the range [0, {@link ListInterface#size()}) an
	 * {@link IndexOutOfBoundsException} will be raised.
	 * 
	 * The running time of this method must be O(n) where n is the index being
	 * removed (not the size of the list). That is remove(0) should run in
	 * constant time.
	 * 
	 * @param n
	 *            the location of the element to retrieve
	 * @return the removed element.
	 * @throws IndexOutOfBoundsException
	 *             if n is not a valid location in the list
	 */
	public T remove(int n)
	{
		T returnvalue;
		if(n<0||n>size)
		throw new IndexOutOfBoundsException();
		else
		{
			 if(n==0)
		        {
		           CircularNode temp=head;
		           returnvalue=(T)temp.getInfo();
		           head=temp.getLink();
		           size--;
		        }
		        else
		        {
		            CircularNode temp=head;
		            while(n>0)
		            {
		               temp=temp.getLink();
		               n--;
		            }
		            CircularNode carry=temp;
		            returnvalue=(T)temp.getInfo();
		            if(temp.getLink()!=null)
		            {        
		            temp=temp.getLink();
		            carry.setLink(temp.getLink());
		            size--;
		            }
		            else
		            {
		                temp.setLink(null);
		                size--;
		            }
		        }
		}
		return returnvalue;
	}

}
