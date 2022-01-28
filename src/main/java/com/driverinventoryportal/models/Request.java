package com.driverinventoryportal.models;

import com.driverinventoryportal.models.dto.RequestDto;
import javax.persistence.*;

/**
 * @author PJ090169
 * This class implements a Request that is linked with Driver class using ManyToOne Relationship
 */
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestNumber;
    private String jiraType;
    private String jiraStatus;
    private String notes;

    /**
     * Here, Request class is being connected using ManyToOne Relationship with Driver class
     * having column name as 'id' with referenced column in Driver class is 'driverId'
     */
    @ManyToOne
    @JoinColumn(name="id", referencedColumnName = "driverId")
    private Driver driver;

    //Default Constructor
    public Request() {}

    public static Request from(RequestDto requestDto){
        Request request = new Request();
        request.setJiraType(requestDto.getJiraType());
        request.setJiraStatus(requestDto.getJiraStatus());
        request.setNotes(requestDto.getNotes());
        return request;
    }

    /**
     *This constructs a Request model with following specified attributes
     * @param jiraType
     * @param jiraStatus
     * @param notes
     */
    public Request(String jiraType, String jiraStatus, String notes) {
        this.jiraType = jiraType;
        this.jiraStatus = jiraStatus;
        this.notes = notes;
    }

    /**
     * @return Request Number
     */
    public int getRequestNumber() {
        return requestNumber; }

    /**
     * @return Jira Type
     */
    public String getJiraType() {
        return jiraType;
    }

    /**
     * @param jiraType
     */
    public void setJiraType(String jiraType) {
        this.jiraType = jiraType;
    }

    /**
     * @return Jira Status
     */
    public String getJiraStatus() {
        return jiraStatus; }
    /**
     * @param jiraStatus
     */
    public void setJiraStatus(String jiraStatus) {
        this.jiraStatus = jiraStatus;
    }

    /**
     * @return Notes
     */
    public String getNotes() {
        return notes; }
    /**
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return Related driver details
     */
    public Driver getDriver() {
        return driver;
    }
    /**
     * @param driver
     */
    public void assignDriver(Driver driver){
        this.driver=driver;    }

}
