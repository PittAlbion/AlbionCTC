package TrainController;

import java.util.Random;
import TrainModel.*;

public class Train{

    private char trackLine;
    private int trainID;
    TrainModel trainModel;
    
    public Train(char p_trackLine, int p_trainID, int p_cars){
        this.trackLine = p_trackLine;
        this.trainID = p_trainID;
        this.trainModel = new TrainModel(p_trackLine, p_trainID, p_cars);
    }
    
    public int GetID(){
        return this.trainID;
    }
    
    public char GetLine(){
        return this.trackLine;
    }
    
    public void SetSpeed(double p_speed){
        this.trainModel.SetPointSpeed(p_speed);
    }
    
    public void SetAuthority(double p_authority){
        this.trainModel.SetAuthority(p_authority);
    }
    
    public void Stop(){
        this.trainModel.SetPointSpeed(0.0);
    }
    
    public boolean NearCrossing(){
        Random number = new Random();
        int hack = number.nextInt(2);
        if (hack == 1)
            return true;
        
        return false;
    }
}