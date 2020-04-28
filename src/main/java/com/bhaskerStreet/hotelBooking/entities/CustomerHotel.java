package com.bhaskerStreet.hotelBooking.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer_hotel")
public class CustomerHotel {

    public CustomerHotel() {
    }

    public CustomerHotel(Long customerId, Long hotelId) {
        this.customerId = customerId;
        this.hotelId = hotelId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "till_date")
    private Date till_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getTill_date() {
        return till_date;
    }

    public void setTill_date(Date till_date) {
        this.till_date = till_date;
    }
}
