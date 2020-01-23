/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.LinearFilter;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RoboRio extends SubsystemBase{

    public RoboRio(){

    }

    double prevXAccel = 0;
    double prevYAccel = 0;
    Accelerometer accelerometer = new BuiltInAccelerometer();
    
    
    public void robotPeriodic() {
        // Gets the current accelerations in the X and Y directions
        double xAccel = accelerometer.getX();
        double yAccel = accelerometer.getY();
        
        // Calculates the jerk in the X and Y directions
        // Divides by .02 because default loop timing is 20ms
        double xJerk = (xAccel - prevXAccel)/.02;
        double yJerk = (yAccel - prevYAccel)/.02;
        prevXAccel = xAccel;
        prevYAccel = yAccel;
    }
   
    

    //new BuiltInAccelerometer();

     //Create a LinearDigitalFilter that will calculate a moving average of the measured X acceleration over the past 10 iterations of the main loop

    //LinearFilter xAccelFilter = LinearFilter.movingAverage(10);

     //Get the filtered X acceleration
    //double filteredXAccel = xAccelFilter.calculate(accelerometer.getX());
    
}
