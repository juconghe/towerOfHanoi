package hanoi;

import structures.List;
import structures.ListInterface;

public class JHanoiSolution implements HanoiSolution {

	List<HanoiMove> Move;
	int numberofrings;
	//JHanoiBoard gameBoard=new JHanoiBoard();
	public JHanoiSolution()
	{
		 Move=new List<HanoiMove>();
	}
	public JHanoiSolution(int n)
	{
		 Move=new List<HanoiMove>();
		 numberofrings=n;
	}
	public void addsolution(HanoiMove move)
	{
		Move.append(move);
	}
	/**
	 * Returns the number of rings that this solution solves for
	 * @return  the number of rings that this solution solves for
	 */
	@Override
	public int getNumberOfRings() {
		// TODO Auto-generated method stub
		return numberofrings;
	}

	/**
	 * Returns a {@link ListInterface} of {@link HanoiMove}s that solves the
	 * Tower of Hanoi puzzle.
	 * @return a {@link ListInterface} of {@link HanoiMove}s that solves the
	 * Tower of Hanoi puzzle.
	 */
	@Override
	public ListInterface<HanoiMove> getMoves() {
		// TODO Auto-generated method stub
		return  Move;
	}

}
