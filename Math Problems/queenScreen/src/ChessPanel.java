import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChessPanel extends JPanel {

    private Image queenWhite, queenBlack;
    private ChessBoard chessBoard;

    public ChessPanel() throws IOException {
        queenWhite = ImageIO.read(new File("pics/queen_white.png"));
        queenBlack = ImageIO.read(new File("pics/queen_black.png"));
        chessBoard = null;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(NQueens.WIDTH, NQueens.HEIGHT);
    }

    // updates the chess board as seen by the GUI
    public void updateChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (chessBoard == null)
            return;
        int tileSize = NQueens.WIDTH / chessBoard.size();
        for (int i = 0, color; i < chessBoard.size(); i++) {
            color = i;
            for (int j = 0; j < chessBoard.size(); j++) {
                if (color % 2 == 0) {
                    g.setColor(Color.WHITE);
                    if (chessBoard.hasQueen(i, j))
                        g.drawImage(queenWhite, j * tileSize, i * tileSize, tileSize, tileSize, null);
                    else
                        g.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
                }
                else {
                    g.setColor(Color.BLACK);
                    if (chessBoard.hasQueen(i, j))
                        g.drawImage(queenBlack, j * tileSize, i * tileSize, tileSize, tileSize,null);
                    else
                        g.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
                }
                color++;
            }
        }
    }
}
