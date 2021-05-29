package society;

import java.awt.*;

public interface IHuman {
    void paint(Graphics graphics);
    int getHealthStatus();
    void setHealthStatus(int healthStatus);
    double getAntibodies();
    int getResistance();
}
