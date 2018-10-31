public class SpawnSheildCommand extends Command {

    public SpawnSheildCommand(Object receiver, String[] args){

        super(receiver , args);
    }
    @Override
    public void Execute() {

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        Square square = (Square)receiver ;
        IAsteroidGameFactory factory = GameBoard.Instance().GetFactory();
        System.out.println("Spawning shield at (" + args[0] + "," + args[1] + ")");
        GameBoard.Instance().GetBoard().get(y).set(x,factory.MakeSheild(square,2));

    }
}
