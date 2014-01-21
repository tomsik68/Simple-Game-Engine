package sk.tomsik68.sge;

import java.awt.Graphics2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpriteManager {
    private Set<Sprite> sprites = new HashSet<Sprite>();
    private Set<Sprite> toAdd = new HashSet<Sprite>();
    private Set<Sprite> toRemove = new HashSet<Sprite>();

    public SpriteManager() {

    }

    public synchronized void update(Game game) {
        for (Sprite sprite : sprites) {
            sprite.update(game);
        }
        if (!toAdd.isEmpty()) {
            sprites.addAll(toAdd);
            toAdd.clear();
        }
        if (!toRemove.isEmpty()) {
            sprites.removeAll(toRemove);
            toRemove.clear();
        }
    }

    public synchronized void render(Graphics2D gfx) {
        for (Sprite sprite : sprites) {
            sprite.render(gfx);
        }
    }

    public void destroyAll() {
        sprites.clear();
    }

    public void addSprite(Sprite sprite) {
        toAdd.add(sprite);
    }

    public void removeSprite(Sprite sprite) {
        toRemove.add(sprite);
    }

    public boolean isEmpty() {
        return sprites.isEmpty();
    }

    public Set<Sprite> getSprites(Class<? extends Sprite> clazz) {
        Set<Sprite> s = new HashSet<Sprite>(sprites);
        Set<Sprite> result = new HashSet<Sprite>();
        for (Sprite sprite : s) {
            if (sprite.getClass().equals(clazz)) {
                result.add(sprite);
            }
        }
        return result;

    }

    public <T extends Sprite> T getCloseSprite(Sprite me, int range, Class<T> type) {
        for (Sprite sprite : sprites) {
            if (sprite != me && type.isInstance(sprite)) {
                if (sprite.getPosition().distance(me.getPosition()) <= range)
                    return (T) sprite;
            }
        }
        return null;
    }

    public boolean isSpriteAlive(Sprite sprite) {
        return sprites.contains(sprite);

    }

    public Set<Sprite> getAllSprites() {
        return sprites;
    }

    public <T extends Sprite> Set<T> getCloseSprites(Sprite me, int range, Class<T> type) {
        HashSet<T> result = new HashSet<T>();
        for (Sprite sprite : sprites) {
            if (sprite != me && type.isInstance(sprite)) {
                if (sprite.getPosition().distance(me.getPosition()) <= range)
                    result.add((T) sprite);
            }
        }
        return result;
    }

}
