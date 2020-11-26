/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tasanajb
 */
@Entity
@Table(name = "DVD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvd.findAll", query = "SELECT d FROM Dvd d"),
    @NamedQuery(name = "Dvd.findByDvdname", query = "SELECT d FROM Dvd d WHERE d.dvdname = :dvdname"),
    @NamedQuery(name = "Dvd.findByRate", query = "SELECT d FROM Dvd d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dvd.findByY", query = "SELECT d FROM Dvd d WHERE d.y = :y"),
    @NamedQuery(name = "Dvd.findByPrice", query = "SELECT d FROM Dvd d WHERE d.price = :price"),
    @NamedQuery(name = "Dvd.findByQuantity", query = "SELECT d FROM Dvd d WHERE d.quantity = :quantity")})
public class Dvd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DVDNAME")
    private String dvdname;
    @Size(max = 50)
    @Column(name = "RATE")
    private String rate;
    @Size(max = 4)
    @Column(name = "Y")
    private String y;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public Dvd() {
    }

    public Dvd(String dvdname) {
        this.dvdname = dvdname;
    }

    public Dvd(String pId, String pName, int pPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDvdname() {
        return dvdname;
    }

    public void setDvdname(String dvdname) {
        this.dvdname = dvdname;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvdname != null ? dvdname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dvd)) {
            return false;
        }
        Dvd other = (Dvd) object;
        if ((this.dvdname == null && other.dvdname != null) || (this.dvdname != null && !this.dvdname.equals(other.dvdname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dvd[ dvdname=" + dvdname + " ]";
    }
    
}
