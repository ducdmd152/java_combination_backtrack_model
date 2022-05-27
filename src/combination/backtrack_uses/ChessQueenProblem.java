package combination.backtrack_uses;

import combination.backtrack.core.BK_Problem;
import combination.backtrack.core.Domain;
import combination.backtrack.core.Proposal;
import combination.backtrack.core.Variable;
import java.util.ArrayList;

/**
 *
 * Code by Duc Dao reference from @author Mr.SuTV
 */
public class ChessQueenProblem extends BK_Problem {
    int size;
    int nQueen;
    ArrayList<ChessPosition> chessBoard = null;

    public ChessQueenProblem(int size, int nQueen) {
        this.size = size;
        this.nQueen = nQueen;
        
        chessBoard = new ArrayList<>();
        for(int row=0;row<size;row++)
            for(int col=0;col<size;col++)
                chessBoard.add(new ChessPosition(row, col));
        
        Domain D = new Domain(chessBoard);
        for(int i=0;i<nQueen;i++) this.add(new Variable(D));
    }
    
    private boolean valid(ChessPosition p1, ChessPosition p2) {
        int dx = p1.row - p2.row;
        if(dx<0) dx=-dx;
        int dy = p1.col - p2.col;
        if(dy<0) dy=-dy;
        
        return (dx!=dy && dx!=0 && dy!=0);
    }

    @Override
    protected boolean accepted() {
        return true;
    }

    @Override
    protected boolean accepted(int i, Object val) {
        proposal.add(val);
        ChessPosition pos = (ChessPosition) val;
        
        for(int j=0;j<i;j++) {
            ChessPosition previous = (ChessPosition) proposal.get(j);
            if(!valid(pos, previous)) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int size = 8;
        int nQueens = 8;
        ChessQueenProblem prob = new ChessQueenProblem(size, nQueens);
        
        ArrayList<Proposal> sols = prob.bkSolve(15);
        
        System.out.println("Solutions for the " + nQueens + " queens problem:");
        if(sols.isEmpty()) System.out.println("No solution!");
        else {
            for(Proposal sol : sols) {
                System.out.println(sol);
            }
            System.out.println(sols.size() + " solution(s).");
        }
    }
}
