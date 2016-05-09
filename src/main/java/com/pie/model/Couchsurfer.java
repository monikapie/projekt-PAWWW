package com.pie.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by pie on 4/26/16.
 */
@Entity
public class Couchsurfer {
    private int id;
    private String name;
    private String surname;
    private String address;
    private Date arrival_date;
    private Date departure_date;
    private int user_id;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String town) {
        this.address = town;
    }

    @Basic
    @Column(name = "arrival_date")
    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    @Basic
    @Column(name = "departure_date")
    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    @Basic
    @Column(name = "user_id")
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Couchsurfer couchsurfer = (Couchsurfer) o;

        if (id != couchsurfer.id) return false;
        if (name != null ? !name.equals(couchsurfer.name) : couchsurfer.name != null) return false;
        if (surname != null ? !surname.equals(couchsurfer.surname) : couchsurfer.surname != null) return false;
        if (address != null ? !address.equals(couchsurfer.address) : couchsurfer.address != null) return false;
        if (arrival_date != null ? !arrival_date.equals(couchsurfer.arrival_date) : couchsurfer.arrival_date != null) return false;
        if (departure_date != null ? !departure_date.equals(couchsurfer.departure_date) : couchsurfer.departure_date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (arrival_date != null ? arrival_date.hashCode() : 0);
        result = 31 * result + (departure_date != null ? departure_date.hashCode() : 0);

        return result;
    }
}
