import java.util.ArrayList;
// Decorator pattern has a  and is a relationship with the component
public abstract class SquareDecorator extends BoardComponent {

    protected BoardComponent tempsquare ;
    int health =2;

    public SquareDecorator(Square tempsquare){

        this.tempsquare = tempsquare  ;
    }

    @Override
    public void Operation()
    {
        this.tempsquare.SheildAlive = true ;
        //Add shield as an observer
        ((Square) this.tempsquare).asteriodimpact.add(this);

        this.tempsquare.Operation();
        // Buildings just stand there, they don't do anything.

        ((Square)this.tempsquare).asteriodimpact.remove(this);
    }

    @Override
    public void Add(BoardComponent child)
    {
        // Do nothing, I'm a leaf.
    }

    @Override
    public void Remove(BoardComponent child)
    {
        // Do nothing, I'm a leaf.
    }

}
