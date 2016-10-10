package hanoi;

public class JHanoiBoard implements HanoiBoard {

	private JHanoiPeg peg0=new JHanoiPeg();
	private JHanoiPeg peg1=new JHanoiPeg();
	private JHanoiPeg peg2=new JHanoiPeg();
	/**
	 * Performs the specified {@link HanoiMove} on this {@link HanoiBoard}.
	 * 
	 * @param move
	 *            the move to perform.
	 * @throws IllegalHanoiMoveException
	 *             if {@code move} is not a legal move.
	 */
	public void doMove(HanoiMove move)
	{
		   if(!isLegalMove(move))
			   throw new IllegalHanoiMoveException();
		   else
		   {
			   switch(move.getFromPeg())
			   {
			   case 0:
			   {
				   switch(move.getToPeg())
				   {
				     case 1: peg1.addRing(peg0.remove());break;
				     case 2: peg2.addRing(peg0.remove());break;
				   }
				   break;
			   }
			   case 1:
			   {
				   switch(move.getToPeg())
				   {
				     case 0: peg0.addRing(peg1.remove());break;
				     case 2: peg2.addRing(peg1.remove());break;				     
				   }
				   break;
			   }
			   case 2:
			   {
				   switch(move.getToPeg())
				   {
				     case 0: peg0.addRing(peg2.remove());break;
				     case 1: peg1.addRing(peg2.remove());break;
				   }
				   break;
			   }
		 }
	 }
 }
		   

	/**
	 * Sets up this {@link HanoiBoard} such that there are {@code n}
	 * {@link HanoiRing}s on the starting {@link HanoiPeg}. The top most
	 * {@link HanoiRing} on the starting peg should be of size 1, and each
	 * {@link HanoiRing} beneath it should increase in size by 1. There should
	 * be no {@link HanoiRing}s on any of the other {@link HanoiPeg}s.
	 * 
	 * @param n
	 *            the number of {@link HanoiRing}s to start the game with.
	 * @throws IllegalArgumentException
	 *             if {@code n} is less than 0.
	 */
	public void setup(int n)
	{
		if(n<0)
			throw new IllegalArgumentException();
		while(n>=1)
		{
			peg0.addRing(new HanoiRing(n));
			n--;
		}
		//System.out.println("Finshed setup");
	}

	/**
	 * Returns {@code true} if the puzzle has been solved and {@code false}
	 * otherwise.
	 * 
	 * @return {@code true} if the puzzle has been solved and {@code false}
	 *         otherwise.
	 */
	public boolean isSolved()
	{
		boolean isSolve=false;
		if(!peg0.hasRings()&&!peg1.hasRings())
			isSolve=true;
		while(peg2.hasRings())
			peg2.remove();
		return isSolve;
	}
	

	/**
	 * Returns {@code true} if the specified move can be performed on this
	 * {@link HanoiBoard} and {@code false} otherwise.
	 * 
	 * @param move
	 *            the move to check
	 * @return {@code true} if the specified move can be performed on this
	 *         {@link HanoiBoard} and {@code false} otherwise.
	 * @throws NullPoinerException if {@code move} is {@code null}
	 */
	public boolean isLegalMove(HanoiMove move)
	{
		if(move==null)
			throw new  NullPointerException();
		  else
		   {
			   switch(move.getFromPeg())
			   {
			   case 0:
			   {
				   switch(move.getToPeg())
				   {
				   case 0: return false;
				     case 1:
				     {
				    	  if(peg0.hasRings())
				    	  {
				    		  if(peg1.hasRings())
				    		  {
				    			  if((peg0.getTopRing().getSize())<(peg1.getTopRing().getSize()))
				    				  return true;
				    			  else
				    				  return false;
				    		  }
				    		  else
				    		  {
				    			  return true;
				    		  }
				    	  }
				    	  else
				    	  {
				    		  return false;
				    	  }
				    	 
				     } 
				     case 2: 
				    	 {
					    	 if(peg0.hasRings())
					    	 {
					    		 if(peg2.hasRings())
					    		 {
					    			 if((peg0.getTopRing().getSize())<(peg2.getTopRing().getSize()))
					    				 return true;
					    			 else
					    				 return false;
					    		 }
					    		 else
					    		 {
					    			 return true;
					    		 }
					    	 }
					    	 else
					    	 {
					    		 return false;
					    	 }
					    	 
				    	 }
				   }
			   }
			   case 1:
			   {
				   switch(move.getToPeg())
				   {
				     case 0:
				     {
				    	 if(peg1.hasRings())
				    	 {
				    		 if(peg0.hasRings())
				    		 {
				    			 if((peg1.getTopRing().getSize())<(peg0.getTopRing().getSize()))
				    				return true;
				    			 else
				    				 return false;
				    		 }
				    		 else
				    		 {
				    			 return true;
				    		 }
				    	 }
				    	 else
				    	 {
				    		 return false;
				    	 }
				    	 
				     }
				     case 1: return false;
				     case 2:
				    	 {
				    		 if(peg1.hasRings())
					    	 {
					    		 if(peg2.hasRings())
					    		 {
					    			 if((peg1.getTopRing().getSize())<(peg2.getTopRing().getSize()))
					    				 return true;
					    			 else
					    				 return false;
					    		 }
					    		 else
					    		 {
					    			 return true;
					    		 }
					    	 }
					    	 else
					    	 {
					    		 return false;	
					    	 }
				    	 }
				   }
			   }
			   case 2:
			   {
				   switch(move.getToPeg())
				   {
				     case 0: 
				    	 {if(peg2.hasRings())
				    	   {
				    		 if(peg0.hasRings())
				    		 {
				    			 if((peg2.getTopRing().getSize())<(peg0.getTopRing().getSize()))
				    				return true;
				    			 else
				    				return false;
				    		 }
				    		 else
				    		 {
				    			 return true;
				    		 }
				    	 }
				    	 else
				    	 {
				    		return false;
				    	 }
				    	 }
				     case 1:
				    	 {
				    		 if(peg2.hasRings())
					    	 {
					    		 if(peg1.hasRings())
					    		 {
					    			 if((peg2.getTopRing().getSize())<(peg1.getTopRing().getSize()))
					    				return true;
					    			 else
					    				 return false;
					    		 }
					    		 else
					    		 {
					    			 return true;
					    		 }
					    	 }
					    	 else
					    	 {
					    		 return false;
					    	 }
				    	 }
				     case 2: return false;
				   }
			   }
		 }
			   System.out.print("Hahaha I got here");
			 return false;
		  
	}
	}
}


