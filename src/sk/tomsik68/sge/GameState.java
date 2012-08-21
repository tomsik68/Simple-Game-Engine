package sk.tomsik68.sge;

import java.awt.Graphics2D;

public interface GameState {
    public void init(StateBasedGame game);
    public void render(Graphics2D gfx);
    public void update(StateBasedGame game);
    public void onExit(GameState newState);
    public int getId();
}
