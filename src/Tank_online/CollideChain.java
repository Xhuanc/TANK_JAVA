package Tank_online;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollideChain implements  Compare{
    private List<Compare> Chain = new LinkedList<>();

    public CollideChain() {
//        Integer.parseInt(String.valueOf(PropertyMgr.get("collides")));
    add(new Bullet_Hit_Tank());
    add(new Tank_Hit_Tank());
    }

    public void add(Compare compare) {
        Chain.add(compare);
    }
    public void remove(Compare compare) {
        Chain.remove(compare);
    }
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < Chain.size(); i++) {
           if(Chain.get(i).TouchEach(o1,o2))
               return true;
        }
        return false;
    }

    @Override
    public boolean TouchEach(GameObject o1, GameObject o2) {
        return  true;
    }
}
