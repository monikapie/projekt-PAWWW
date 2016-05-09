package com.pie.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by pie on 4/26/16.
 */
@Entity
public class Journey {
    private int id;
    private String name;
    private String country;
    private Integer cost;
    private Date start_date;
    private Date end_date;
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
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date startDate) {
        this.start_date = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date endDate) {
        this.end_date = endDate;
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

        Journey journey = (Journey) o;

        if (id != journey.id) return false;
        if (name != null ? !name.equals(journey.name) : journey.name != null) return false;
        if (country != null ? !country.equals(journey.country) : journey.country != null) return false;
        if (cost != null ? !cost.equals(journey.cost) : journey.cost != null) return false;
        if (start_date != null ? !start_date.equals(journey.start_date) : journey.start_date != null) return false;
        if (end_date != null ? !end_date.equals(journey.end_date) : journey.end_date != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (start_date != null ? start_date.hashCode() : 0);
        result = 31 * result + (end_date != null ? end_date.hashCode() : 0);
        return result;
    }
}
