package fr.univ_amu.ia_engine;

import fr.univ_amu.GameBoard;
import fr.univ_amu.entity.Ghost;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.entity.Wall;
import fr.univ_amu.physic_engine.Collision;
import fr.univ_amu.utils.Direction;

import java.util.List;
import java.util.Random;

import static fr.univ_amu.utils.Direction.*;

public class IA {

    //Direction priorities
    //List<Direction> directions = new ArrayList<>(4);
    Direction[] directions = new Direction[4];
    GameBoard board = GameBoard.getInstance();

    public IA() {
    }

    public void processDirection() {
        Pacman pacman = board.getPacman();
        List<Ghost> ghosts = board.getGhosts();

        double pacman_x = pacman.getPhysiqueShape().getxPosition();
        double pacman_y = pacman.getPhysiqueShape().getyPosition();

        Ghost ghost = ghosts.get(0);
        double ghost_x = ghost.getPhysiqueShape().getxPosition();
        double ghost_y = ghost.getPhysiqueShape().getyPosition();

        int random_number = new Random().nextInt(2);
        System.out.println(random_number);

        if (random_number == 0) {
            if (pacman_x > ghost_x) {
                directions[0] = RIGHT;
                directions[3] = LEFT;
            } else {
                directions[0] = LEFT;
                directions[3] = RIGHT;
            }
            if (pacman_y < ghost_y) {
                directions[1] = UP;
                directions[2] = DOWN;
            } else {
                directions[1] = DOWN;
                directions[2] = UP;
            }
        } else {
            if (pacman_x > ghost_x) {
                directions[1] = RIGHT;
                directions[2] = LEFT;
            } else {
                directions[1] = LEFT;
                directions[2] = RIGHT;
            }
            if (pacman_y < ghost_y) {
                directions[0] = UP;
                directions[3] = DOWN;
            } else {
                directions[0] = DOWN;
                directions[3] = UP;
            }
        }

        boolean move = false;
        for (int i = 0; i < directions.length; i++) {
            ghost.setCurrentDirection(directions[i]);

            ghost.movePhysicShape();

            if (!this.wallCollisionExists(ghost)) {
                //System.out.println("i = " + i + " direction = " + directions[i]);
                move = true;
                break;
            } else {
                ghost.undoMovePhysicShape();
            }
        }

        if (move) {
            ghost.moveGraphicShape();
        }

    }

    public boolean wallCollisionExists(Ghost ghost) {
        boolean isCollision = false;
        for(Wall w : board.getWalls()) {
            if (Collision.checkCollision(ghost.getPhysiqueShape(), w.getPhysiqueShape())) {
                isCollision = true;
                break;
            }
        }
        return isCollision;
    }

}
