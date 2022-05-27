package combination.backtrack_uses;

/**
 *
 * Code by Duc Dao reference from @author Mr.SuTV
 */
public class ChessPosition {
    int row, col;

    public ChessPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ')';
    }
}
