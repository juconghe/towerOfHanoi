package algorithms;

public class BasicMathRecursion implements BasicMath {

	@Override
	public boolean isEven(int val) {
          if(val==0)
        	  return true;
          else
        	  if(val==1)
        		  return false;
          else
        	  if(val>0)
        	  return isEven(val-2);
        	  else
        		  return isEven(val+2);
	}

	@Override
	public boolean isOdd(int val) {
		return !isEven(val);
	}

	@Override
	public int sumN(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Input must be greater than 0.");
		else
			if(n==0)
				return 0;
			else
			{
				return n+sumN(n-1);
			}
	}

	@Override
	public int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		else
			if(n==0)
				return 1;
			else
			{
				return (n*factorial(n-1));
			}
	}

	@Override
	public int biPower(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		else
			if(n==0)
				return 1;
			else
				return 2*biPower(n-1);
		// TODO Figure out what this <<= thing is.
	}

}
