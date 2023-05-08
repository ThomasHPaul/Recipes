package com.thiftypantry;

public class Step {

    private int number;
    private String note;
    private int durationInMinutes;

    public Step(int number, String note, int durationInMinutes) {
        this.number = number;
        setNote(note);
        this.durationInMinutes = durationInMinutes;
    }

    public int getNumber() { return number; }
    public String getNote() { return note; }
    public int getDurationInMinutes() { return durationInMinutes; }

    public void setNumber(int number) { this.number = number; }
    public void setNote(String note) {
        if(note == null) {
            throw new IllegalArgumentException("Step.note cannot be null");
        }
        if (note.equals("")) {
            throw new IllegalArgumentException("Step.note cannot be blank");
        }
        this.note = note;
    }
    public void setDurationInMinutes(int durationInMinutes) { this.durationInMinutes = durationInMinutes; }

    @Override
    public String toString() {
        return "{" + number + ": " + note + " for " + durationInMinutes + " minutes}";
    }
}
