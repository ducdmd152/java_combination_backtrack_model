package combination.backtrack.core;

import java.util.ArrayList;

/**
 *
 * Code by Duc Dao reference from @author Mr.SuTV
 */

public class Proposal extends ArrayList {
    public void removeFrom(int index) {
        for(int i=this.size()-1;i>=index;i--)
            this.remove(i);
    }
}
