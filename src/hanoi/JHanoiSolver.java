package hanoi;


public class JHanoiSolver implements HanoiSolver {

	private JHanoiSolution ListSolution;
	private JHanoiBoard Board=new JHanoiBoard();
	/**
	 * Solves the Tower of Hanoi puzzle for {@code n} rings.
	 * @param n the number of rings
	 * @return a {@link HanoiSolution} representing the moves to be played
	 * @throws IllegalArgumentException if {@code n} is less than 0.
	 */
	@Override
	public HanoiSolution solve(int n) {
		if(n<0)
			throw new IllegalArgumentException();
		else
		{
			ListSolution=new JHanoiSolution(n);
			Board.setup(n);
			solver(n,0,1,2);
			Board.isSolved();
			return ListSolution;
		}
}
	private void solver(int n,int from,int help,int end)
	{
		if(n==0)
			return;
		if(n==1)
		{
			Board.doMove(new HanoiMove(from,end));
			ListSolution.addsolution(new HanoiMove(from,end));
			return;
		}
		else
		{
			solver(n-1,from,end,help);
			Board.doMove(new HanoiMove(from,end));
			ListSolution.addsolution(new HanoiMove(from,end));
			solver(n-1,help,from,end);
			return;
		}
	}
}