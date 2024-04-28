package org.round.three.service;

import org.round.three.model.BookingEntity;
import org.round.three.model.TrainEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingHelper {

    public boolean checkTicketAvailability(List<BookingEntity> bookingChart, char source, char destination, int noOfTickets){
        TrainEntity trainEntity = new TrainEntity();
        Integer sourceIndex = trainEntity.getSourceIndex(source);
        Integer destinationIndex = trainEntity.getSourceIndex(destination);
        if(noOfTickets<=trainEntity.getNoOfSeats() && sourceIndex !=null && destinationIndex != null && destinationIndex>sourceIndex){
            List<BookingEntity> bookedTickets = bookingChart.stream().filter(x-> BookingEntity.BookingStatus.CONFIRMED.equals(x.getBookingStatus()) && ((sourceIndex>=trainEntity.getSourceIndex(x.getSourceStation()) && sourceIndex<trainEntity.getSourceIndex(x.getDestinationStation()) )||
                    (destinationIndex>trainEntity.getSourceIndex(x.getSourceStation())  && destinationIndex<=trainEntity.getSourceIndex(x.getDestinationStation())))).toList();
            Optional<Integer> noOfBookedTicket = bookedTickets.stream().map(BookingEntity::getNoOfPassenger).reduce(Integer::sum);
            return noOfBookedTicket.map(integer -> (trainEntity.getNoOfSeats() - integer) >= noOfTickets).orElse(true);
        } else {
            return false;
        }
    }

    public boolean checkWaitingList(List<BookingEntity> bookingChart, char source, char destination, int noOfTickets){
        TrainEntity trainEntity = new TrainEntity();
        Integer sourceIndex = trainEntity.getSourceIndex(source);
        Integer destinationIndex = trainEntity.getSourceIndex(destination);
        if(noOfTickets<=trainEntity.getNoOfWLSeats() && sourceIndex !=null && destinationIndex != null && destinationIndex>sourceIndex){
            List<BookingEntity> bookedTickets = bookingChart.stream().filter(x-> BookingEntity.BookingStatus.WL.equals(x.getBookingStatus()) && ((sourceIndex>=trainEntity.getSourceIndex(x.getSourceStation()) && sourceIndex<trainEntity.getSourceIndex(x.getDestinationStation()) )||
                    (destinationIndex>trainEntity.getSourceIndex(x.getSourceStation())  && destinationIndex<=trainEntity.getSourceIndex(x.getDestinationStation())))).toList();
            Optional<Integer> noOfWLTicket = bookedTickets.stream().map(BookingEntity::getNoOfPassenger).reduce(Integer::sum);
            return noOfWLTicket.map(integer -> (trainEntity.getNoOfWLSeats() - integer) >= noOfTickets).orElse(true);

        } else {
            return false;
        }
    }

    public List<BookingEntity> getEqualantWL(List<BookingEntity> bookingChart, BookingEntity bookingEntity) {
        TrainEntity trainEntity = new TrainEntity();
        Integer sourceIndex = trainEntity.getSourceIndex(bookingEntity.getSourceStation());
        Integer destinationIndex = trainEntity.getSourceIndex(bookingEntity.getDestinationStation());
        if(sourceIndex !=null && destinationIndex != null && destinationIndex>sourceIndex){
            return bookingChart.stream().filter(x->BookingEntity.BookingStatus.WL.equals(x.getBookingStatus()) && (bookingEntity.getPnr()!=x.getPnr())&& (sourceIndex<=trainEntity.getSourceIndex(x.getSourceStation()) && destinationIndex>=trainEntity.getSourceIndex(x.getDestinationStation()))).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
