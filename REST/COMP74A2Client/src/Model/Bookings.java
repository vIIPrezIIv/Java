/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Ray
 */
public class Bookings implements Serializable{
    
    /**
     * Variables
     */
    int id;
    int bookingId;
    //String bookingDate;
    String bookingMonth;
    String bookingDay;
    String bookingYear;
    String arrivalDate;
    String vacancyDate;
    String roomNumber;
    String bookingName;
    int hotelId;
    int clientId;
    String destination;
    String departure;
    
    /**
     * Constructor
     * @param id
     * @param bookingId
     * @param bookingDate
     * @param arrivalDate
     * @param vacancyDate
     * @param roomNumber
     * @param bookingName
     * @param hotelId
     * @param clientId 
     * @param destination
     * @param departure
     */
    
    /**
     * Default Constructor
     */
    public Bookings()
    {
        
    }
    
    public Bookings(int id, int bookingId, String bookingMonth, String bookingDay, String bookingYear, String arrivalDate, String vacancyDate, String roomNumber, String bookingName, int hotelId, int clientId, String destination, String departure)
    {
        this.id = id;
        this.bookingId = bookingId;
        this.arrivalDate = arrivalDate;
        //this.bookingDate = bookingDate;
        this.bookingMonth = bookingMonth;
        this.bookingDay = bookingDay;
        this.bookingYear = bookingYear;
        this.bookingName = bookingName;
        this.roomNumber = roomNumber;
        this.vacancyDate = vacancyDate;
        this.hotelId = hotelId;
        this.clientId = clientId;
        this.destination = destination;
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /*public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }*/

    public String getBookingMonth() {
        return bookingMonth;
    }

    public void setBookingMonth(String bookingMonth) {
        this.bookingMonth = bookingMonth;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getBookingYear() {
        return bookingYear;
    }

    public void setBookingYear(String bookingYear) {
        this.bookingYear = bookingYear;
    }
    
    

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setVacancyDate(String vacancyDate) {
        this.vacancyDate = vacancyDate;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
    public int getId() {
        return id;
    }

    public int getBookingId() {
        return bookingId;
    }

    /*public String getBookingDate() {
        return bookingDate;
    }*/
    
    public String getArrivalDate() {
        return arrivalDate;
    }
    
    public String getVacancyDate() {
        return vacancyDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBookingName() {
        return bookingName;
    }
    
    @Override
    public String toString()
    {
        return id + " " + bookingId + " " +
               bookingMonth + "-" + bookingDay + "-" + 
               bookingYear + " " + arrivalDate + " " +
               vacancyDate + " " + roomNumber + " " +
               bookingName + " " + hotelId + " " +
               clientId + " " + destination + " " +
               departure;
    }
}
