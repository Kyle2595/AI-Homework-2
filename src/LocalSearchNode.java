
/* A fairly minimal container for Local Search information
 * 
 */
public class LocalSearchNode
{
	private LocalSearchState _state;
	private int _numberOfSteps;  // number of steps in Search, used for analysis

	public LocalSearchNode(LocalSearchState state,int steps) 
	{
		_state = state;
		_numberOfSteps = steps;
	}

	public LocalSearchState getState() 
	{
		return _state;
	}

	public Double getValue()
	{
		return _state.value();

	}
	public int getSteps()
	{
		return _numberOfSteps;
	}

	public String toString()
	{
		return "<"+_state+", "+ _state.value()+"("+_numberOfSteps+")>";
	}
}