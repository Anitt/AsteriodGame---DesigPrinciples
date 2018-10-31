import java.util.ArrayList;

// Square is a composite, making up the Composite pattern (contains components)
public class Square extends BoardComponent
{
	private final ArrayList<BoardComponent> children;
	private BoardComponent parent;
	public ISubject asteriodimpact;
	public boolean sheildavilable ;
	
	public Square()
	{
		super();
		children = new ArrayList<BoardComponent>();
		this.asteriodimpact = new Subject() ;

	}

	@Override
	public void Operation()
	{
		// adding Observors through subject observable pattern

			if(!SheildAlive)
			for (int j = 0; j < children.size(); j++) {

				asteriodimpact.add(children.get(j));
			}



		ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
		for (int i = 0; i < childrenCopy.size(); i++)
		{
			BoardComponent child = childrenCopy.get(i);
			child.Operation();
		}


		// Removing the observors so that the numbers of observors always remain as 4 .
         asteriodimpact.removeall();
	}

	@Override
	public void Add(BoardComponent child)
	{
		// I am now this child's parent.
		children.add(child);
		child.SetParent(this);
	}

	@Override
	public void Remove(BoardComponent child)
	{
		children.remove(child);
	}

	@Override
	public void update() {


	}
}