import java.util.Arrays;
import java.util.List;

public class StateClass implements LocalSearchState {

	private int _numberOfQueens;
	private int[][] _bordArray;
	private int _currentQueen;

	public int getNumberOfQueens() 
	{
		return _numberOfQueens;
	}

	public void setNumberOfQueens(int _numberOfQueens) 
	{
		this._numberOfQueens = _numberOfQueens;
	}

	public int[][] getBordArray() 
	{
		return _bordArray;
	}

	public void setBordArray(int[][] _bordArray) 
	{
		this._bordArray = _bordArray;
	}

	public StateClass(int n)
	{
		setNumberOfQueens(n);

		int[][] multi = new int[n][n];
		setBordArray(multi);

		for(int i=0; i < n; i++)
		{
			_bordArray[i][i] = 1;
		}
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
		for(int i=0; i < _numberOfQueens; i++)
		{
			int QueenCol = i;

			if(action == "Move UP")
			{
				int row = Arrays.asList(nextState._bordArray[QueenCol]).indexOf(1);
				nextState._bordArray[QueenCol][row] = 0;
				nextState._bordArray[QueenCol][row + 1] = 1;
			}

			if(action == "Move DOWN")
			{
				int row = Arrays.asList(nextState._bordArray[QueenCol]).indexOf(1);
				nextState._bordArray[QueenCol][row] = 0;
				nextState._bordArray[QueenCol][row - 1] = 1;
			}
		}
		return nextState;
	}

	@Override
	public Double value() 
	{
		Double val = 0.0;

		// Finds how many queens are in the same row
		for(int i=0; i < _numberOfQueens; i++)
		{
			for(int j=0; j < _numberOfQueens; j++)
			{
				int tempVal = 0;

				if(_bordArray[i][j] == 1)
				{
					tempVal++;
				}

				if(tempVal > 1)
				{
					val++;
				}
			}		
		}

		// Finds the number of queens in a diagonal
		for(int i=0; i < _numberOfQueens; i++)
		{
			for(int j=0; j < _numberOfQueens; j++)
			{

			}
		}
		return val;
	}
}
