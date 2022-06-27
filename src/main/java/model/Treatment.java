package model;

import utils.DateConverter;

import java.time.LocalDate;
import java.time.LocalTime;

public class Treatment {
    private long tid;
    private long pid;
    private long cid;
    private LocalDate date;
    private LocalTime begin;
    private LocalTime end;
    private String description;
    private String remarks;

    /**
     * @param pid         Person ID
     * @param date        Treatment Date
     * @param begin       Start time of the treatment
     * @param end         End time of the treatment
     * @param description Brief description of the activity
     * @param remarks     Remarks
     **/
    public Treatment(long pid, long cid, LocalDate date, LocalTime begin,
                     LocalTime end, String description, String remarks) {
        this.pid = pid;
        this.cid = cid;
        this.date = date;
        this.begin = begin;
        this.end = end;
        this.description = description;
        this.remarks = remarks;
    }

    /**
     * @param tid         Treatment ID
     * @param pid         Person ID
     * @param cid         Caregiver ID
     * @param date        Treatment Date
     * @param begin       Start time of the treatment
     * @param end         End time of the treatment
     * @param description Brief description of the activity
     * @param remarks     Remarks
     **/
    public Treatment(long tid, long pid, long cid, LocalDate date, LocalTime begin,
                     LocalTime end, String description, String remarks) {
        this.tid = tid;
        this.pid = pid;
        this.cid = cid;
        this.date = date;
        this.begin = begin;
        this.end = end;
        this.description = description;
        this.remarks = remarks;
    }

    public long getTid() {
        return tid;
    }

    public long getPid() {
        return this.pid;
    }

    public long getCid() {
        return this.cid;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setDate(String s_date) {
        this.date = DateConverter.convertStringToLocalDate(s_date);
    }

    public void setBegin(String begin) {
        this.begin = DateConverter.convertStringToLocalTime(begin);
    }

    public void setEnd(String end) {
        this.end = DateConverter.convertStringToLocalTime(end);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String toString() {
        return "\nBehandlung" + "\nTID: " + this.tid +
                "\nPID: " + this.pid +
                "\nDate: " + this.date +
                "\nBegin: " + this.begin +
                "\nEnd: " + this.end +
                "\nDescription: " + this.description +
                "\nRemarks: " + this.remarks + "\n";
    }
}