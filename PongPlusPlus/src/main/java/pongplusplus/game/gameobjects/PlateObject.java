package pongplusplus.game.gameobjects;

public interface PlateObject {

    void checkMovement(double deltaInSec);
    void checkChangeBallSpeedAbilityActivation();
    void checkStealEnemyPointsAbilityActivation();

}
