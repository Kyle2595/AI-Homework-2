

public class HillClimber {

	private LocalSearchNode _current;
	private int _shoulderSearchStepsAllowed;  // this is the number of "shoulder steps" allowed
	// may need more instance variables
	
	public static void main(String[] args) {
		LocalSearchState initial = new StateClass(4);  // this should be a real LocalState (can change N)
		HillClimber qc = new HillClimber(new LocalSearchNode(initial,0),0);
		LocalSearchNode sol = qc.findSolution();
		System.out.println(sol.getState()+" "+sol.getSteps());
	}

	public HillClimber(LocalSearchNode initial, int searchShoulder){
		_current = initial;
		_shoulderSearchStepsAllowed = searchShoulder;
	}

	public LocalSearchNode findSolution() 
	{
		while (true) 
		{
			// TODO  write the code in this loop
			//       be sure that you return
			return null;  // dummy return so this looks like working code
		}
	}
}
