import java.util.LinkedList;

public class HillClimber {

	private LocalSearchNode _current;
	private int _shoulderSearchStepsAllowed;  // this is the number of "shoulder steps" allowed
	private LinkedList<LocalSearchNode> _fringe; 

	public static void main(String[] args) {
		LocalSearchState initial = new StateClass(4);  // this should be a real LocalState (can change N)
		HillClimber qc = new HillClimber(new LocalSearchNode(initial,0),0);
		LocalSearchNode sol = qc.findSolution();
		System.out.println(sol.getState()+" "+sol.getSteps());
	}

	public HillClimber(LocalSearchNode initial, int searchShoulder){
		_current = initial;
		_shoulderSearchStepsAllowed = searchShoulder;
		_fringe.add(new LocalSearchNode(initial.getState(),0));
	}

	public LocalSearchNode findSolution() 
	{
		LocalSearchNode element;
		LocalSearchState currentState;
		LocalSearchState tempState;
		int steps = 0;
		// loop until find goal or run out of nodes to search from

		while (true) 
		{ 
			if (_fringe.isEmpty())
				return null;
			else 
			{
				element = _fringe.remove();
				currentState = element.getState();
				for (String s: element.getState().actions()) 
				{
					tempState = currentState.successor(s); 
					if (currentState.value() != 0)
					{
						steps++;
						_fringe.addFirst(new LocalSearchNode(tempState, steps));
					}
				}
			}
		}
	}
}
