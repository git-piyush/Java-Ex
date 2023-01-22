<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script
	src="https://www.jqueryscript.net/demo/jQuery-Date-Time-Picke-Plugin-Simple-Datetimepicker/jquery.simple-dtpicker.js"></script>
<link type="text/css"
	href="https://www.jqueryscript.net/demo/jQuery-Date-Time-Picke-Plugin-Simple-Datetimepicker/jquery.simple-dtpicker.css"
	rel="stylesheet">

<title>Event Creator</title>
</head>
<body>
	<h2>Create Event</h2>
	<s:form action="login.action" method="post">
		<label>Event Description :</label>
		<input class="" name="eventDescription" id="eventDesc" value="">
		<br>

		<label for='startdt'> Start Date: </label>
		<input class="dtpicker" name="startDateTime" id="startdt" value="">

		<label for='enddt'> End Date: </label>
		<input class="dtpicker" name="endDateTime" id="enddt" value="">

		<s:submit method="createEvent" key="label.createEvent" align="center" />
	</s:form>

	<script type="text/javascript">
		$(function() {
			// -- append by class just for lower strings count --
			$('.dtpicker').appendDtpicker({
				"minuteInterval" : 15,
				"calendarMouseScroll" : false,
				"futureOnly" : true,
				"autodateOnStart" : false
			});

			$('#startdt').change(function() {
				$('#enddt').handleDtpicker('setMinDate', $('#startdt').val()); //set end datetime not lower then start datetime
			});
		});
	</script>


</body>
</html>