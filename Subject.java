import java.util.ArrayList;

public class Subject implements ISubject {

    public ArrayList<BoardComponent> observers ;

    public Subject() {

        observers = new ArrayList<BoardComponent>();
    }

    @Override
    public void add(BoardComponent boardComponent) {

        observers.add(boardComponent);

    }

    @Override
    public void remove(BoardComponent boardComponent) {


        observers.remove(boardComponent);
    }

    @Override
    public void removeall()
    {
        observers.clear();
    }

    @Override
    public void notifyObserver() {

        for (BoardComponent boardComponent : observers){

              boardComponent.update();

        }

    }
}
