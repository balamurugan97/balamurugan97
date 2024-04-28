package org.round.three.model;

public class BookingEntity {

    public enum BookingStatus{
        CONFIRMED,WL,CANCELED
    }
    private char sourceStation;
    private char destinationStation;
    private int pnr;
    private int noOfPassenger;
    private BookingStatus bookingStatus;

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public char getDestinationStation() {
        return destinationStation;
    }

    public char getSourceStation() {
        return sourceStation;
    }

    public int getPnr() {
        return pnr;
    }

    public int getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setDestinationStation(char destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void setNoOfPassenger(int noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }

    public void setSourceStation(char sourceStation) {
        this.sourceStation = sourceStation;
    }
}
