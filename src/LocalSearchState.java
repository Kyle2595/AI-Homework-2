
import java.util.List;

public interface LocalSearchState {
	List<String> actions(); // possible actions while in this state
	LocalSearchState successor(String action);  
	Double value();  // estimated value of this state (thing to maximize)
	}
