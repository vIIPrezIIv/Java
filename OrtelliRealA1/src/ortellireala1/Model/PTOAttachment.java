/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortellireala1.Model;

/**
 *
 * @author Ray
 */
public abstract class PTOAttachment extends Attachment {
    
    private double speed;
    
    /**
     * This function gets the speed of the PTO
     * @return 
     */
    public double getSpeed()
    {
        return this.speed;
    }
    
    /**
     * This function sets the speed for the PTO
     * @param newSpeed 
     */
    public void setSpeed(double newSpeed)
    {
        this.speed = newSpeed;
    }
    
}
