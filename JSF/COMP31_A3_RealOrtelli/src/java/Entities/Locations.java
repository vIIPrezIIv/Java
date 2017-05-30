/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ray
 */
@Entity
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l"),
    @NamedQuery(name = "Locations.findByLocationsId", query = "SELECT l FROM Locations l WHERE l.locationsId = :locationsId"),
    @NamedQuery(name = "Locations.findByLocationName", query = "SELECT l FROM Locations l WHERE l.locationName = :locationName")})
public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "locationsId")
    private Integer locationsId;
    @Size(max = 25)
    @Column(name = "locationName")
    private String locationName;

    public Locations() {
    }

    public Locations(Integer locationsId) {
        this.locationsId = locationsId;
    }

    public Integer getLocationsId() {
        return locationsId;
    }

    public void setLocationsId(Integer locationsId) {
        this.locationsId = locationsId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationsId != null ? locationsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locationsId == null && other.locationsId != null) || (this.locationsId != null && !this.locationsId.equals(other.locationsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Locations[ locationsId=" + locationsId + " ]";
    }
    
}
