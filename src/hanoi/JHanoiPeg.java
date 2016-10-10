package hanoi;

public class JHanoiPeg implements HanoiPeg {

	private LinkedStack<HanoiRing> RingStack=new LinkedStack<HanoiRing>();
	
	public JHanoiPeg()
	{
	}
	/**
	 * Adds the specified {@link HanoiRing} to the top of this {@link HanoiPeg}.
	 * 
	 * @param ring
	 *            the ring to put at the top of the {@link HanoiPeg}
	 * @throws IllegalHanoiMoveException
	 *             if the {@link HanoiRing} being added to the top is not
	 *             smaller than the top most {@link HanoiRing} on this
	 *             {@link HanoiPeg}.
	 * @throws NullPointerException
	 *             if {@code ring} is {@code null}
	 */
	@Override
	public void addRing(HanoiRing ring) {
		
		if(ring==null)
			throw new NullPointerException();
		else
		{
			if(!RingStack.isEmpty())
			{
				if(ring.getSize()>=RingStack.top().getSize())
					throw new IllegalHanoiMoveException();
				else
				{
				   	RingStack.push(ring);
				}
			}
			else
			{
				RingStack.push(ring);
			}
		}

	}

	/**
	 * Removes the top most {@link HanoiRing} from this {@link HanoiPeg} and
	 * returns it.
	 * 
	 * @return the {@link HanoiRing} that was removed.
	 * @throws IllegalHanoiMoveException
	 *             if this {@link HanoiPeg} does not contain any
	 *             {@link HanoiRing}s
	 */
	@Override
	public HanoiRing remove() {
		if(RingStack.isEmpty())
			throw new IllegalHanoiMoveException();
		else
		{
			return RingStack.pop();
		}
	}


	/**
	 * Returns the top most {@link HanoiRing} from this {@link HanoiPeg}
	 * 
	 * @return the top most {@link HanoiRing} from this {@link HanoiPeg}
	 */
	
	@Override
	public HanoiRing getTopRing() {
		return RingStack.top();
	}

	/**
	 * Returns {@code true} if this {@link HanoiPeg} has one or more
	 * {@link HanoiRing}s on it and {@code false} otherwise.
	 * 
	 * @return {@code true} if this {@link HanoiPeg} has one or more
	 *         {@link HanoiRing}s on it and {@code false} otherwise.
	 */
	
	@Override
	public boolean hasRings() {
		if(RingStack.isEmpty())
			return false;
		else
			return true;
	}

}
