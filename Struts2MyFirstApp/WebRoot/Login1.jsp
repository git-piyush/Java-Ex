<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="https://www.jqueryscript.net/demo/jQuery-Date-Time-Picke-Plugin-Simple-Datetimepicker/jquery.simple-dtpicker.js"></script>
	<link type="text/css" href="https://www.jqueryscript.net/demo/jQuery-Date-Time-Picke-Plugin-Simple-Datetimepicker/jquery.simple-dtpicker.css" rel="stylesheet">
<sx:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.css">
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
  
<title>Struts 2 - Login Application | dineshonjava.com</title>
<style type="text/css">
		body { background-color: #fefefe; padding-left: 2%; padding-bottom: 100px; color: #101010; }
		footer{ font-size:small;position:fixed;right:5px;bottom:5px; }
		a:link, a:visited  { color: #0000ee; }
		pre{ background-color: #eeeeee; margin-left: 1%; margin-right: 2%; padding: 2% 2% 2% 5%; }
		p { font-size: 0.9rem; }
		ul { font-size: 0.9rem; }
		hr { border: 2px solid #eeeeee; margin: 2% 0% 2% -3%; }
		h3 { border-bottom: 2px solid #eeeeee; margin: 2rem 0 2rem -1%; padding-left: 1%; padding-bottom: 0.1em; }
		h4 { border-bottom: 1px solid #eeeeee; margin-top: 2rem; margin-left: -1%; padding-left: 1%; padding-bottom: 0.1em; }
	</style>
</head>
<body>
<h5>Not lower then start date example</h5>
<s:form>
<label for='startdt'> Start Date: </label>
	<input type="text" class="dtpicker" name="startDateTime" id="startdt" value="">

<label for='enddt'> End Date: </label>
	<input type="text" class="dtpicker" name="endDateTime" id="enddt" value="">
	
	<s:submit method="createEvent" key="label.createEvent" align="center" />
</s:form>

<script type="text/javascript">
	$(function(){
	 	// -- append by class just for lower strings count --
		$('.dtpicker').appendDtpicker({"minuteInterval": 15, "calendarMouseScroll": false, "futureOnly": true, "autodateOnStart": false});

		$('#startdt').change(function() {
		     $('#enddt').handleDtpicker('setMinDate', $('#startdt').val()); //set end datetime not lower then start datetime
		});
	});
</script>


</body>
</html>