import java.util.Arrays;
import java.util.List;

public class StateClass implements LocalSearchState {
	
	private int _numberOfQueens;
	
	public int getNumberOfQueens() 
	{
		return _numberOfQueens;
	}

	public void setNumberOfQueens(int _numberOfQueens) 
	{
		this._numberOfQueens = _numberOfQueens;
	}

	public StateClass(int n)
	{
		setNumberOfQueens(n);
	}

	@Override
	public List<String> actions() 
	{
		List<String> actionList = Arrays.asList("Move UP",
				"Move DOWN",
				"Move LEFT",
				"Move RIGHT");
		return actionList;
	}

	@Override
	public LocalSearchState successor(String action) 
	{
		StateClass nextState = new StateClass(getNumberOfQueens());
		
		if(action == "Move UP")
		{

		}

		if(action == "Move DOWN")
		{

		}

		if(action == "Move LEFT")
		{

		}

		if(action == "Move RIGHT")
		{

		}
		return nextState;
	}

	@Override
	public Double value() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
