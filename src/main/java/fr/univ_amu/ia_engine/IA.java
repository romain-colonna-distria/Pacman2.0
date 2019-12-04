package fr.univ_amu.ia_engine;

import fr.univ_amu.GameBoard;
import fr.univ_amu.element.DynamicElement;
import fr.univ_amu.element.Element;
import fr.univ_amu.entity.Ghost;
import fr.univ_amu.entity.Pacman;
import fr.univ_amu.entity.Trail;

import java.util.ArrayList;
import java.util.List;

import static fr.univ_amu.utils.Direction.*;

public class IA {

    GameBoard board = GameBoard.getInstance();
    Pacman pacman = board.getPacman();
    List<Ghost> ghosts = board.getGhosts();
    List<Trail> trails = board.getTrails();

    public IA() {

    }

    public void shortestPath(DynamicElement dynamicElement, Element element) {

        List<Trail> unsettled = new ArrayList<>();
        List<Trail> settled = new ArrayList<>();

        Trail source = getTrailFromPos(dynamicElement.getPhysiqueShape().getxPosition(), dynamicElement.getPhysiqueShape().getyPosition());
        if (source != null) {

            source.setDistance(0);
            unsettled.add(source);

            Trail dest = getTrailFromPos(element.getPhysiqueShape().getxPosition(), element.getPhysiqueShape().getyPosition());

            if (dest != null) {
                while (!unsettled.isEmpty()) {
                    Trail min = getMinDistanceTrail(unsettled);

                    unsettled.remove(min);
                    List<Trail> neighbors = board.getNeighborTrails(min);

                    Trail destNearest = getNeareast(neighbors, dest);
                    if (!settled.contains(destNearest)) {
                        destNearest.setDistance(min.getDistance() + 1);
                        unsettled.add(destNearest);
                    }

                    settled.add(min);

                    if (min == dest) {
                        break;
                    }
                }


                if (settled.size() > 1) {
                    setDirection(dynamicElement, settled.get(1));
                    move(dynamicElement);
                }

            }
        } else {
            move(dynamicElement);
        }


    }

    private Trail getTrailFromPos(double x, double y) {
        Trail res = null;
        for (Trail trail : trails) {
            if (trail.getPhysiqueShape().getxPosition() == x && trail.getPhysiqueShape().getyPosition() == y) {
                res = trail;
                break;
            }
        }
        return res;
    }

    public Trail getMinDistanceTrail(List<Trail> trails) {
        Trail min = trails.get(0);
        for (Trail trail : trails) {
            if (trail.getDistance() < min.getDistance()) {
                min = trail;
            }
        }
        return min;
    }

    public Trail getNeareast(List<Trail> trails, Trail dest) {
        double dest_x = dest.getPhysiqueShape().getxPosition();
        double dest_y = dest.getPhysiqueShape().getyPosition();
        Trail nearest = trails.get(0);
        double minEuclideanDistance = euclideanDistance(nearest.getPhysiqueShape().getxPosition(), nearest.getPhysiqueShape().getyPosition(), dest_x, dest_y);
        for (Trail trail : trails) {
            double trail_x = trail.getPhysiqueShape().getxPosition();
            double trail_y = trail.getPhysiqueShape().getyPosition();
            double euclideanDistance = euclideanDistance(trail_x, trail_y, dest_x, dest_y);
            if (euclideanDistance < minEuclideanDistance) {
                minEuclideanDistance = euclideanDistance;
                nearest = trail;
            }
        }
        return nearest;
    }

    public double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((Math.pow(x1 - x2, 2)) + Math.pow(y1 - y2, 2));
    }

    public void setDirection(DynamicElement ghost, Trail dest) {
        double ghost_x = ghost.getPhysiqueShape().getxPosition();
        double ghost_y = ghost.getPhysiqueShape().getyPosition();
        double dest_x = dest.getPhysiqueShape().getxPosition();
        double dest_y = dest.getPhysiqueShape().getyPosition();
        if (dest_x < ghost_x && dest_y == ghost_y) {
            ghost.setCurrentDirection(LEFT);
        }
        if (dest_x > ghost_x && dest_y == ghost_y) {
            ghost.setCurrentDirection(RIGHT);
        }
        if (dest_y < ghost_y && dest_x == ghost_x) {
            ghost.setCurrentDirection(UP);
        }
        if (dest_y > ghost_y && dest_x == ghost_x) {
            ghost.setCurrentDirection(DOWN);
        }
    }

    public void move(DynamicElement ghost) {
        ghost.movePhysicShape();
        ghost.moveGraphicShape();
    }

    public void run() {
        for (int i = 0; i < ghosts.size(); i++) {
            shortestPath(ghosts.get(i), pacman);
        }
    }

}
