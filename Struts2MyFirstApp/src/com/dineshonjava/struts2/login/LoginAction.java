package com.dineshonjava.struts2.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.opensymphony.xwork2.ActionSupport;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.util.UidGenerator;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private String startDateTime;
	private String endDateTime;
	private InputStream inputStream;
    private String fileName;
    private long contentLength;
    private String eventDescription;

	public String execute() {
		System.out.println("execute method");
		if (this.username.equals("piyush") && this.password.equals("piyush")) {
			return "success";
		} else {
			addActionError(getText("error.login"));
			return "error";
		}
	}

	public String createEvent() throws IOException, ValidationException, ParseException {
		
		String sDateTime = this.startDateTime;
		String[] part = sDateTime.split("[- :]");
		int year = Integer.parseInt(part[0]);
		int month = Integer.parseInt(part[1])-1;
		int day = Integer.parseInt(part[2]);
		int hh = Integer.parseInt(part[3]);
		int mm = Integer.parseInt(part[4]);
		int ss = 0;
		
		String eDateTime = this.endDateTime;
		String[] part1 = eDateTime.split("[- :]");
		int year1 = Integer.parseInt(part1[0]);
		int month1 = Integer.parseInt(part1[1])-1;
		int day1 = Integer.parseInt(part1[2]);
		int hh1 = Integer.parseInt(part1[3]);
		int mm1 = Integer.parseInt(part1[4]);
		int ss1 = 0;	
		
		ZoneId zoneId = ZoneId.systemDefault();
		String calFile = "D://mycalendar.ics";
		// Create a TimeZone
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone(zoneId.toString());
		VTimeZone tz = timezone.getVTimeZone();
		java.util.Calendar startDate = new GregorianCalendar();
		startDate.setTimeZone(timezone);
		startDate.set(java.util.Calendar.MONTH, month);
		startDate.set(java.util.Calendar.DAY_OF_MONTH, day);
		startDate.set(java.util.Calendar.YEAR, year);
		startDate.set(java.util.Calendar.HOUR_OF_DAY, hh);
		startDate.set(java.util.Calendar.MINUTE, mm);
		startDate.set(java.util.Calendar.SECOND, ss);
		
		java.util.Calendar endDate = new GregorianCalendar();
		endDate.setTimeZone(timezone);
		endDate.set(java.util.Calendar.MONTH, month1);
		endDate.set(java.util.Calendar.DAY_OF_MONTH, day1);
		endDate.set(java.util.Calendar.YEAR, year1);
		endDate.set(java.util.Calendar.HOUR_OF_DAY, hh1);
		endDate.set(java.util.Calendar.MINUTE, mm1);
		endDate.set(java.util.Calendar.SECOND, ss1);
		
		// Create the event
		String eventName = this.eventDescription;
		DateTime start = new DateTime(startDate.getTime());
		DateTime end = new DateTime(endDate.getTime());
		VEvent meeting = new VEvent(start, end, eventName);
		// add timezone info..

		meeting.getProperties().add(tz.getTimeZoneId());
		// generate unique identifier..

		UidGenerator ug = new UidGenerator("uidGen");
		Uid uid = ug.generateUid();
		meeting.getProperties().add(uid);

		// Create a calendar

		net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
		icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
		icsCalendar.getProperties().add(CalScale.GREGORIAN);
		// Add the event and print

		icsCalendar.getComponents().add(meeting);
		// Saving an iCalendar file
		FileOutputStream fout = new FileOutputStream(calFile);
		CalendarOutputter outputter = new CalendarOutputter();
		outputter.setValidating(false);
		outputter.output(icsCalendar, fout);

		System.out.println(icsCalendar);
		byte[] calByte = icsCalendar.toString().getBytes();

		File fileToDownload = new File("D://mycalendar.ics");	 
        inputStream = new FileInputStream(fileToDownload);
        fileName = fileToDownload.getName();
        contentLength = fileToDownload.length();
		
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime1(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime1(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	
}
