package com.thiftypantry;

public class Step {

    private int number;
    private String note;
    private int durationInMinutes;

    public Step(int number, String note, int durationInMinutes) {
        setNumber(number);
        setNote(note);
        setDurationInMinutes(durationInMinutes);
    }

    public int getNumber() { return number; }
    public String getNote() { return note; }
    public int getDurationInMinutes() { return durationInMinutes; }

    public void setNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("Step.number cannot be less than 1");
        }
        this.number = number; }
    public void setNote(String note) {
        if(note == null) {
            throw new IllegalArgumentException("Step.note cannot be null");
        }
        if(note.equals("")) {
            throw new IllegalArgumentException("Step.note cannot be blank");
        }
        if(note.trim().equals("")) {
            throw new IllegalArgumentException("Step.note cannot contain only whitespace (spaces, tabs, newlines)");
        }
        this.note = note;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        if(durationInMinutes < 1) {
            throw new IllegalArgumentException("Step.durationInMinutes cannot be less than 1");
        }
        this.durationInMinutes = durationInMinutes; }

    @Override
    public String toString() {
        return "{" + number + ": " + note + " for " + durationInMinutes + " minutes}";
    }
}
