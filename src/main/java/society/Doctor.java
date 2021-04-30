package society;

public class Doctor {

    public void diagnose(Human human) {
        if (human.healthStatus == 1 && human.resistance <= 3){
            human.recoveryTime -= 32;
            if (human.recoveryTime <= 0) {
                human.velocity.reset();
                human.healthStatus = 3;
                human.numInfected--;
            }
        }

        else if (human.healthStatus == 1 && human.resistance >= 8){
            human.recoveryTime -= 32;
            if (human.recoveryTime <= 0){
                human.healthStatus = 2;
                human.numInfected--;
            }
        }

        else if (human.healthStatus == 1 && human.resistance < 8 && human.resistance > 3){
            human.velocity.div(1.001);
            human.recoveryTime -= 16;
            if (human.recoveryTime <= 0){
                human.velocity.mult(2);
                human.healthStatus = 2;
                human.numInfected--;
            }
        }
    }
}
