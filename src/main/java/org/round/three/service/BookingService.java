package org.round.three.service;

import org.round.three.model.BookingEntity;
import org.round.three.model.TrainEntity;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class BookingService {


    public void book(List<BookingEntity> bookingChart, char source, char destination, int noOfTickets) {
        BookingHelper helper = new BookingHelper();
        Random random = new Random();
        if(helper.checkTicketAvailability(bookingChart,source,destination,noOfTickets)){
            BookingEntity bookingEntity = new BookingEntity();
            bookingEntity.setSourceStation(source);
            bookingEntity.setDestinationStation(destination);
            bookingEntity.setNoOfPassenger(noOfTickets);
            bookingEntity.setBookingStatus(BookingEntity.BookingStatus.CONFIRMED);
            bookingEntity.setPnr(random.nextInt());
            bookingChart.add(bookingEntity);
            System.out.println(bookingEntity.getPnr()+" booked");
        } else {
            if(helper.checkWaitingList(bookingChart,source,destination,noOfTickets)){
                BookingEntity bookingEntity = new BookingEntity();
                bookingEntity.setSourceStation(source);
                bookingEntity.setDestinationStation(destination);
                bookingEntity.setNoOfPassenger(noOfTickets);
                bookingEntity.setBookingStatus(BookingEntity.BookingStatus.WL);
                bookingEntity.setPnr(random.nextInt());
                bookingChart.add(bookingEntity);
                System.out.println(bookingEntity.getPnr()+" booked");
            } else {
                System.out.println("due to ticket unavailability between station, this booking should fail");
            }
        }
    }

    public void cancel(List<BookingEntity> bookingChart, int pnr, int noOfTickets) {
        BookingHelper helper = new BookingHelper();
        Optional<BookingEntity> bookingEntity = bookingChart.stream().filter(x->x.getPnr()==pnr).findFirst();
        if(bookingEntity.isPresent() && (bookingEntity.get().getNoOfPassenger()>=noOfTickets)){
            int noOfPassenger = bookingEntity.get().getNoOfPassenger();
            bookingEntity.get().setNoOfPassenger(noOfPassenger - noOfTickets);
            System.out.println(bookingEntity.get().getPnr()+" cancel No of Tickets - "+noOfTickets);
            List<BookingEntity> wlEntity = helper.getEqualantWL(bookingChart,bookingEntity.get());
            if(wlEntity!= null){
                final int[] ticketsAssign = {noOfTickets};
                bookingChart.forEach(x->{
                    Optional<BookingEntity> wlEntityB = wlEntity.stream().filter(y->y.getPnr()==x.getPnr()).findFirst();
                    if(wlEntityB.isPresent() && wlEntityB.get().getNoOfPassenger()<= ticketsAssign[0]){
                        wlEntityB.get().setBookingStatus(BookingEntity.BookingStatus.CONFIRMED);
                        ticketsAssign[0] = ticketsAssign[0] -wlEntityB.get().getNoOfPassenger();
                        System.out.println(wlEntityB.get().getPnr()+" WL booked");
                    }
                });
            } else {
                System.out.println("No WL Found");
            }
        }
    }

    public void printChart(List<BookingEntity> bookingChart) {
        TrainEntity trainEntity = new TrainEntity();
        for(int i=0;i<=trainEntity.getNoOfStop();i++){
            if(i==0){
                System.out.println("\t");
            } else {
                System.out.println(trainEntity.getStation()[i-1]+"\t");
            }
            for(int j=0;j<=trainEntity.getNoOfSeats();j++)
                if (i == 0) {
                    System.out.println("\t");
                } else if (j == 0) {
                    System.out.println((j + 1) + "\t");
                }
        }
        bookingChart.forEach(chart-> System.out.println(chart.getPnr()+"---"+chart.getNoOfPassenger()+"---"+chart.getSourceStation()+"----"+chart.getDestinationStation()+"---"+ chart.getBookingStatus()));
    }
}
