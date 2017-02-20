import java.util.LinkedList;

public class HillClimber {

	private LocalSearchNode _current;
	public static int _shoulderSearchStepsAllowed;  // this is the number of "shoulder steps" allowed
	private LinkedList<LocalSearchNode> _fringe;
	private static int _n;

	public static void setN(int x)
	{
		_n = x;
	}

	public static int getN()
	{
		return _n;
	}

	public static void main(String[] args) {
		setN(4);
		LocalSearchState initial = new StateClass(_n);  // this should be a real LocalState (can change N)
		HillClimber qc = new HillClimber(new LocalSearchNode(initial,0));
		LocalSearchNode sol = qc.findSolution();
		System.out.println(sol.getState()+" "+sol.getSteps());
	}

	public HillClimber(LocalSearchNode initial){
		_current = initial;
		_fringe.add(new LocalSearchNode(initial.getState(),0));
	}

	// Solution method with and without shoulder moves
	public LocalSearchNode findSolution() 
	{
		LocalSearchNode element;
		LocalSearchState neighborState;
		LocalSearchState currentState;
		int steps = 0;

		while (true)
		{
			if (_fringe.isEmpty())
				return null;
			else
			{
				element = _fringe.remove();
				currentState = element.getState();
				int neighborMax = getN();
				
				for (String s: element.getState().actions()) 
				{
					neighborState = currentState.successor(s);
					
					if(_shoulderSearchStepsAllowed > 0)
					{
						if(neighborState.value() < neighborMax)
						{
							currentState = neighborState;
							neighborMax = neighborState.value().intValue();
						}
					}
					else
					{
						if(neighborState.value() <= neighborMax)
						{
							currentState = neighborState;
							neighborMax = neighborState.value().intValue();
							if(neighborState.value() == neighborMax)
							{
								_shoulderSearchStepsAllowed--;
							}
						}
					}
				}
				steps++;
				_fringe.addFirst(new LocalSearchNode(currentState, steps));
			}
		}
	}
}
