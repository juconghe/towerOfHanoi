package structures;

public class CircularNode<T> {

	private CircularNode link;
	private T info;
	
	public CircularNode(T info)
	{
		this.info=info;
		link=null;
	}
     
	public void setInfo(T info)
	{
		this.info=info;		
	}
	
	public T getInfo()
	{
		return info;
	}
	
	
	public void setLink(CircularNode link)
	{
		this.link=link;
	}
	
	public CircularNode getLink()
	{
		return link;
	}
}
