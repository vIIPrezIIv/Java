/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortellireala1.Model;



/**
 * This class holds the methods for the tractors
 * @author Ray
 */
public class Tractor {
    
    private boolean engineOn;
    private float throttle;
    private int gear;
    private String stringGear;
    private final int rearWheelDiameter;
    private double rpm;
    private double gearRatio;
    private boolean PTOStatus;
    private double vehicleSpeed;
    private String engineStatus;
    private boolean attachmentStatus;
    private Attachment attachment;
    private String PTOSpeedOut;
    private float height;
  
    /**
     * Constructor.
     */
    public Tractor(){
        this.engineOn = false;
        this.gear = 1;
        this.stringGear = "neutral";
        this.throttle = 0f;
        this.rearWheelDiameter = 4;
        this.rpm = 0; 
        this.PTOStatus = false;
        this.attachmentStatus = false;
        this.engineStatus = "Not Started";
        this.height = 0f;
    }
    
    /**
     * This is a enum that stores values for gear.
     */
    public enum Gear{
        
        neutral, low, mid, high;
        /*
        private final int gearRatio;
        Gear (int input) {this.gearRatio = input;}
        int getGearRatio(Gear input)
        {
            return gearRatio;
        }
        */
    }
    
    /**
     * This method starts the engine.
     */
    public void startEngine(){
        
        if (this.gear == 1 && this.PTOStatus == false)
        {
            if (this.throttle > 10)
            {
                this.engineOn = true;
                this.rpm = (this.throttle * 24);
                this.engineStatus = "Started";
            }
        }
    }
    
    /**
     * This method stops the engine.
     */
    public void stopEngine(){
        
        this.engineOn = false;
        this.rpm = 0;
        this.engineStatus = "Not Started";
        this.vehicleSpeed = 0;
        
        if(attachment instanceof PTOAttachment)
        {
            double speed = 0;
                    
            ((PTOAttachment)attachment).setSpeed(speed);    
        }
    }
    
    /**
     * This method takes user input on for the throttle and changes it.
     * @param throttle 
     */
    public void setThrottle(float throttle){
        
        if (throttle >= 0 && throttle <= 100)
        {
            if (throttle < 10)
            {
                this.throttle = throttle;
                stopEngine();
            }
            else
            {
                this.throttle = throttle;
                
                if (engineOn == true)
                {
                    this.rpm = (this.throttle * 24);
                }
                
                if(attachment instanceof PTOAttachment)
                {
                    double speed = this.vehicleSpeed * 0.25;
                    
                    ((PTOAttachment)attachment).setSpeed(speed);    
                }
            }
        }
    }
    
    /**
     * This method takes user input and changes the gear depending on the input.
     * Also calculates the vehicle speed.
     * @param newGear 
     */
    public void setGear(Gear newGear){
        
        this.stringGear = newGear.toString();
        
        switch(newGear)
        {
            case neutral: 
                this.gearRatio = 0;
                this.gear = 1;
                
                if(attachment instanceof PTOAttachment)
                {
                    double speed = 0;
                    
                    ((PTOAttachment)attachment).setSpeed(speed);    
                }
                
                break;
            case low: 
                this.gearRatio = 20;
                this.gear = 2;
                break;
            case mid: 
                this.gearRatio = 10;
                this.gear = 3;
                break;
            case high: 
                this.gearRatio = 5;
                this.gear = 4;
                break;
        }

        if (this.gear != 1)
        {
            this.vehicleSpeed = (this.rpm / this.gearRatio * this.rearWheelDiameter * 60) / 1000.0;
            
            if(attachment instanceof PTOAttachment)
            {
                double speed = this.vehicleSpeed * 0.25;
                    
                ((PTOAttachment)attachment).setSpeed(speed);    
            }
        }
        else
        {
            this.vehicleSpeed = 0;
        }
    }
    
    /**
     * This method converts everything to a string to be printed.
     * @return 
     */
    @Override public String toString(){ 
                
        if(attachment instanceof PTOAttachment)
        {
            PTOSpeedOut = (", PTO Speed = " + ((PTOAttachment)attachment).getSpeed() + "KPM");
        }
        else
        {
            PTOSpeedOut = " ";
        }  
        
        return "Tractor " + this.engineStatus + ", Throttle = " + this.throttle + ", Engine RPM = " + this.rpm + ", Tractor Speed = " + this.vehicleSpeed + "KPM, Gear = " + this.stringGear + this.PTOSpeedOut; 
    }
    
    /**
     * This function attaches and attachment
     * @param selection 
     */
    public void attach(Attachment selection)
    {
        if (attachmentStatus == false)
        {
            this.attachment = selection;
            this.attachmentStatus = true;
        }
    }
    
    /**
     * This function engagePTO
     */
    public void engagePTO()
    {
        double speed = this.vehicleSpeed * 0.25;
        
        this.PTOStatus = true;
        
        if(attachment instanceof PTOAttachment)
        {
            ((PTOAttachment)attachment).setSpeed(speed); 
        } 
    }
    
    /**
     * This function disengagePTO 
     */
    public void disengagePTO()
    {
        double speed = 0;
        
        this.PTOStatus = false;
        
        if(attachment instanceof PTOAttachment)
        {
            ((PTOAttachment)attachment).setSpeed(speed); 
        }
    }
    
    /**
     * This function removes an attachment
     */
    public void remove()
    {  
        this.attachmentStatus = false;
        this.attachment = null;
    }
    
    /**
     * This function lets you use the attachment
     * @return 
     */
    /*public String use()
    {
        String returnString = "";
                
        switch(attachment.toString())
        {
            case "harrow":
                returnString = "You used the Harrow";
                break;
                
            case "auger":
                if(PTOStatus == true)
                {
                    returnString = "You used the Auger";
                }
                else
                {
                    returnString = "Need to engage the PTO";
                }
            
                break;
                
            case "blade":
                returnString = "You used the Blade";
                break;
                
            case "rake":
                returnString = "You used the Rake";
                break;
                
            case "mower":
                if(PTOStatus == true)
                {
                    returnString = "You used the Mower";
                }
                else
                {
                    returnString = "Need to engage the PTO";
                }
                
                break;
                
            case "snowblower":
                if(PTOStatus == true)
                {
                    returnString = "You used the Snow Blower";
                }
                else
                {
                    returnString = "Need to engage the PTO";
                }

                break;
        }
        
        return returnString;
    }*/
    
    /**
     * This function sets the height for the tractor arm
     * @param height 
     */
    public void setHeight(float height)
    {
        if (height >= 0 && height <= 10)
        {
            this.height = height;
        }
    }
    
    /**
     * This function returns the status of the attachment.
     * @return 
     */
    public boolean getAttachment()
    {
        return this.attachmentStatus;
    }
    
    /**
     * This returns the PTOStatus
     * @return 
     */
    public boolean getPTOStatus()
    {
        return this.PTOStatus;
    }
    
    /**
     * This function returns attachment object
     * @return 
     */
    public Attachment getAttachmentObject()
    {
        return this.attachment;
    }
    
    /**
     * This function returns the off/on status for the engine
     * @return 
     */
    public boolean getEngineOn()
    {
        return this.engineOn;
    }
    
    /**
     * This returns the number for the gear selected
     * @return 
     */
    public int getGear()
    {
        return this.gear;
    }
}