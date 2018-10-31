public interface ISubject {

    public void add(BoardComponent boardComponent);
    public void remove(BoardComponent boardComponent);
    public void removeall();
    public void notifyObserver();

}
