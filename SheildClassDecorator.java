import java.util.ArrayList;

public class SheildClassDecorator extends SquareDecorator {

    public SheildClassDecorator(Square tempsquare ) {
        super(tempsquare);
    }

    @Override
    public void Operation()
    {
        // The operation performed by Asteroid objects is to fall from the sky
        // one level at a time, when they hit the Sheild (Sheildhealth == 0) the sheild is removed from the square
        super.Operation();

    }

    @Override
    public void Add(BoardComponent child)
    {
        // I'm a leaf!
    }

    @Override
    public void Remove(BoardComponent child)
    {
        // I'm a leaf!
    }

    @Override
    public void update() {

        health -= 1;
        if (0 == health)
        {
            // when sheild health is decremented to zero the shelid is removed from the square
            this.tempsquare.SheildAlive  = false ;

            ArrayList<ArrayList<BoardComponent>> board = GameBoard.Instance().GetBoard();

            for (int i = 0; i < board.size(); i++)
            {
                ArrayList<BoardComponent> row = board.get(i);
                for (int j = 0; j < row.size(); j++)
                {
                    if(row.get(j).equals(this))
                    {
                        row.set(j,this.tempsquare);

                        return;
                    }
                }
            }


        }

    }



}
