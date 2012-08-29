package sk.tomsik68.sge;

public abstract class StateBasedGame extends Game {
    private GameState[] states;
    private int currentState = 0;
    public StateBasedGame(ListenerAttachable l,GraphicsAdapter ga, int stateCount) {
        super(l,ga);
        states = new GameState[stateCount];
    }
    @Override
    public void init() {
        super.init();
        initStates();
    }
    protected abstract void initStates();
    protected final void addState(GameState state){
        states[state.getId()] = state;
    }
    @Override
    protected void render() {
        super.render();
        states[currentState].render(gfx);
    }
    @Override
    protected void update() {
        super.update();
        states[currentState].update(this);
    }
    public final void switchState(int state){
        states[currentState].onExit(states[state]);
        currentState = state;
        states[currentState].init(this);
    }
    public GameState getCurrentState(){
        return states[currentState];
    }
}
