package org.round.three;

import org.round.three.model.BookingEntity;
import org.round.three.service.BookingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Booking {
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ticket Booking System");
        String operations = sc.nextLine();
        BookingService bookingService = new BookingService();
        List<BookingEntity> bookingChart = new ArrayList<>();
        List<String> operationValue = splitOperation(operations);
        while(!Objects.equals(operationValue.get(0), "exit")){
            switch (operationValue.get(0)) {
                case "book" ->
                        bookingService.book(bookingChart, operationValue.get(1).toCharArray()[0], operationValue.get(2).toCharArray()[0], Integer.parseInt(operationValue.get(3)));
                case "cancel" ->
                        bookingService.cancel(bookingChart, Integer.parseInt(operationValue.get(1)), Integer.parseInt(operationValue.get(2)));
                case "chart" -> bookingService.printChart(bookingChart);
                case "exit" -> System.exit(0);
                default -> System.out.println("default");
            }
            operations = sc.nextLine();
            operationValue = splitOperation(operations);
        }

    }

    private static List<String> splitOperation(String operations) {
        String operationValue="";
        List<String> operationValues = new ArrayList<>();
        int i=0;
        for(char c:operations.toCharArray()){
            if(c==','){
                operationValues.add(operationValue);
                operationValue = "";
            } else {
                operationValue+=c;
            }
            if(i==operations.length()-1){
                operationValues.add(operationValue);
            }
            i++;
        }
        return operationValues;
    }
}
