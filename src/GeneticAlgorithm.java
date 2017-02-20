import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class GeneticAlgorithm {
	
	private LocalSearchNode _current;
	private Double _fitness;  // this is the number of "shoulder steps" allowed
	private LinkedList<LocalSearchNode> _fringe; 

	public static void main(String[] args) {
		LocalSearchState initialState = new StateClass(4);  // this should be a real LocalState (can change N)
		GeneticAlgorithm qc = new GeneticAlgorithm(new LocalSearchNode(initialState,0), initialState.value());
		LocalSearchNode sol = qc.findSolution();
		System.out.println(sol.getState()+" "+sol.getSteps());
	}
	
	public GeneticAlgorithm (LocalSearchNode initialNode, Double fitness){
		_current = initialNode;
		_fitness = fitness;
		_fringe.add(new LocalSearchNode(initialNode.getState(), 0));
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
					LocalSearchState x = currentState.successor("Move UP");;
					LocalSearchState y = currentState.successor("Move DOWN");;
					LocalSearchNode child = Reproduce(x,y);
					
					if(ThreadLocalRandom.current().nextInt(1, 11) < 3)
					{
						child = Mutate(child);
						_fringe.add(child);
					}
				}
			}
		}
	}
	
	public LocalSearchNode Reproduce(LocalSearchState x, LocalSearchState y)
	{
		LocalSearchNode tempNode = _current;
		
		if(x.value() > y.value())
		{	
			int n = x.value().intValue();
			int c = ThreadLocalRandom.current().nextInt(1, n + 1);
			
			tempNode.setSteps(c);
		}
		else
		{
			Reproduce(y,x);
		}
		return tempNode;
	}
}
