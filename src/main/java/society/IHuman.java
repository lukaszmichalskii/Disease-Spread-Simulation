package society;

import java.awt.*;

public interface IHuman {
    void paint(Graphics graphics);
    int getHealthStatus();
    void setHealthStatus(int healthStatus);
    int getAntibodies();
}
