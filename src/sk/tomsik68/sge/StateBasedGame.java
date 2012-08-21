package sk.tomsik68.sge;

import java.awt.Canvas;

public abstract class StateBasedGame extends Game {
    private GameState[] states;
    private int currentState = 0;
    public StateBasedGame(Canvas canvas, int stateCount) {
        super(canvas);
        states = new GameState[stateCount];
    }
    @Override
    protected void init() {
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
}
