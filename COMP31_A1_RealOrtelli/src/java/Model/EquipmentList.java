/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement
//@XmlType(propOrder={"eventEquip"})
//@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author Ray
 */
public class EquipmentList /*implements Serializable*/ extends ArrayList<Equip> {
    
    //@XmlElementWrapper(name="eventEquip")
    /**
     * get for EquipmentList
     * @return 
     */
    @XmlElement(name="equipment") 
    public ArrayList<Equip> getList()
    {
        return this;
    }
    /*private ArrayList<Equip> eventEquip;
    
    public EquipmentList() {
        eventEquip = new ArrayList<>();
    }
    
    public ArrayList<Equip> getEventEquip() {
        return eventEquip;
    }
    
    public void setEventEquip(ArrayList<Equip> newEquip) {
        this.eventEquip = newEquip;
    }*/

}
