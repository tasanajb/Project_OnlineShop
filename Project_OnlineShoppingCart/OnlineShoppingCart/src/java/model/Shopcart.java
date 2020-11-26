/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Iterator;
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
@Table(name = "SHOPCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shopcart.findAll", query = "SELECT s FROM Shopcart s"),
    @NamedQuery(name = "Shopcart.findByDvdname", query = "SELECT s FROM Shopcart s WHERE s.dvdname = :dvdname"),
    @NamedQuery(name = "Shopcart.findByRate", query = "SELECT s FROM Shopcart s WHERE s.rate = :rate"),
    @NamedQuery(name = "Shopcart.findByY", query = "SELECT s FROM Shopcart s WHERE s.y = :y"),
    @NamedQuery(name = "Shopcart.findByPrice", query = "SELECT s FROM Shopcart s WHERE s.price = :price"),
    @NamedQuery(name = "Shopcart.findByQuantity", query = "SELECT s FROM Shopcart s WHERE s.quantity = :quantity")})
public class Shopcart implements Serializable {

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

    public Shopcart() {
    }

    public Shopcart(String dvdname) {
        this.dvdname = dvdname;
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
        if (!(object instanceof Shopcart)) {
            return false;
        }
        Shopcart other = (Shopcart) object;
        if ((this.dvdname == null && other.dvdname != null) || (this.dvdname != null && !this.dvdname.equals(other.dvdname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shopcart[ dvdname=" + dvdname + " ]";
    }

    public Iterator<Dvd> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
