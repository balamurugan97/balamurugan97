package org.round.three.model;

public class TrainEntity {
    private int noOfSeats =8;
    private int noOfWLSeats=2;
    private char trainStart='A';
    private char trainEnd='E';
    private char [] station ={'A','B','C','D','E','F'};
    private int noOfStop = 5;

    public int getNoOfWLSeats() {
        return noOfWLSeats;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public char getTrainStart() {
        return trainStart;
    }

    public char getTrainEnd() {
        return trainEnd;
    }

    public int getNoOfStop() {
        return noOfStop;
    }

    public char[] getStation() {
        return station;
    }


    public void setNoOfStop(int noOfStop) {
        this.noOfStop = noOfStop;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setNoOfWLSeats(int noOfWLSeats) {
        this.noOfWLSeats = noOfWLSeats;
    }

    public void setTrainEnd(char trainEnd) {
        this.trainEnd = trainEnd;
    }

    public void setTrainStart(char trainStart) {
        this.trainStart = trainStart;
    }

    public void setStation(char[] station) {
        this.station = station;
    }

    public Integer getSourceIndex(char source) {
        int i=0;
        int index = 0;
        for(char c: station){
            if(c==source){
                index = i;
            }
            i++;
        }
        return index;
    }
}
