package com.driverinventoryportal.models.dto;

import com.driverinventoryportal.models.Request;

/**
 * @author PJ090169
 * This class implements a RequestDto that can be used by controller to add and update request instead of
 * using Persistent entity directly in Request Mapping which could expose threat to our database from intruder
 */
public class RequestDto {
        private int requestNumber;
        private String jiraType;
        private String jiraStatus;
        private String notes;

    /**
     * @param request
     * @return DriverDto class is interconnected with Driver class
     */
        public static RequestDto from(Request request){
            RequestDto requestDto = new RequestDto();
            requestDto.setRequestNumber(request.getRequestNumber());
            requestDto.setJiraStatus(request.getJiraStatus());
            requestDto.setJiraType(request.getJiraType());
            requestDto.setNotes(request.getNotes());
            return requestDto;
        }

    //default constructor
    public RequestDto(){}

    /**
     *
     * @param jiraType
     * @param jiraStatus
     * @param notes
     */
    public RequestDto(String jiraType, String jiraStatus, String notes) {
        this.jiraType = jiraType;
        this.jiraStatus = jiraStatus;
        this.notes = notes; }

    /**
     * @return Request Number
     */
    public int getRequestNumber() {
        return requestNumber; }
    /**
     * @param requestNumber
     */
    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber; }
    /**
     * @return Jira Type
     */
    public String getJiraType() {
        return jiraType; }
    /**
     * @param jiraType
     */
    public void setJiraType(String jiraType) {
        this.jiraType = jiraType; }

    /**
     * @return Jira Status
     */
    public String getJiraStatus() {
        return jiraStatus; }
    /**
     * @param jiraStatus
     */
    public void setJiraStatus(String jiraStatus) {
        this.jiraStatus = jiraStatus; }

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
}
