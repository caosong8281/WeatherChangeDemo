<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Weather for cities</title>
<script type="text/javascript" src='<%=basePath %>resources/js/jquery-1.8.3.min.js'></script>
<script language="javascript">
var weatherCode = [
	 [100,"Sunny"]
	,[101,"Cloudy"]
	,[102,"Few Clouds"]
	,[103,"Partly Cloudy"]
	,[104,"Overcast"]
	,[200,"Windy"]
	,[201,"Calm"]
	,[202,"Light Breeze"]
	,[203,"Moderate"]
	,[204,"Fresh Breeze"]
	,[205,"Strong Breeze"]
	,[206,"High Wind"]
	,[207,"Gale"]
	,[208,"Strong Gale"]
	,[209,"Storm"]
	,[210,"Violent Storm"]
	,[211,"Hurricane"]
	,[212,"Tornado"]
	,[213,"Tropical Storm"]
	,[300,"Shower Rain"]
	,[301,"Heavy Shower Rain"]
	,[303,"Heavy Thunderstorm"]
	,[304,"Thundershower with hail"]
	,[305,"Light Rain"]
	,[306,"Moderate Rain"]
	,[307,"Heavy Rain"]
	,[308,"Extreme Rain"]
	,[309,"Drizzle Rain"]
	,[310,"Storm"]
	,[311,"Heavy Storm"]
	,[312,"Severe Storm"]
	,[313,"Freezing Rain"]
	,[311,"Heavy Storm"]
	,[312,"Severe Storm"]
	,[313,"Freezing Rain"]
	,[314,"Light to moderate rain"]
	,[315,"Moderate to heavy rain"]
	,[316,"Heavy rain to storm"]
	,[317,"Storm to heavy storm"]
	,[318,"Heavy to severe storm"]
	,[399,"Rain"]
	,[400,"Light Snow"]
	,[401,"Moderate Snow"]
	,[402,"Heavy Snow"]
	,[403,"Snowstorm"]
	,[404,"Sleet"]
	,[405,"Rain And Snow"]
	,[406,"Shower Snow"]
	,[407,"Snow Flurry"]
	,[408,"Light to moderate snow"]
	,[409,"Moderate to heavy snow"]
	,[410,"Heavy snow to snowstorm"]
	,[499,"Snow"]
	,[500,"Mist"]
	,[501,"Foggy"]
	,[502,"Haze"]
	,[503,"Sand"]
	,[504,"Dust"]
	,[507,"Duststorm"]
	,[508,"Sandstorm"]
	,[509,"Dense fog"]
	,[510,"Strong fog"]
	,[511,"Moderate haze"]
	,[512,"Heavy haze"]
	,[513,"Severe haze"]
	,[514,"Heavy fog"]
	,[515,"Extra heavy fog"]
	,[900,"Hot"]
	,[901,"Cold"]
	,[999,"Unknown"]
	];

	function change(obj) {
		var location;
		location = obj.value;
		if (obj.value == "Wollongong") {
			location = "Canberra";  // there is no Wollongong in api, so i replace that with a major city in Australia which is Canberra.
		}		
		showWeatherInfo(location);
		$("#cityName").text(obj.value);
	}
	
	function showWeatherInfo(abc) {
		var apiServer = "https://free-api.heweather.net/s6/weather/now";// common weather interface
		$.ajax( {
			url : apiServer,
			type : 'get',	
			async : false,
			dataType : 'json',
			data : {
				"location" : abc,
				"key" : "956bc183fdf646b69a19a1c27ae2d501"
			},
			success : function(data, status) {
				if (typeof(data.HeWeather6[0].now) == "undefined") {
					$("#weather").hide();
					alert("there is no weather info for this city");
					return;
				}
				$("#weather").show();
				var citycode = data.HeWeather6[0].now.cond_code; // citycode
				var temperature = data.HeWeather6[0].now.tmp + "°C"; // temperature;
				var wind = data.HeWeather6[0].now.wind_spd + "km/h"; // windspeed;		
				var updateObj = data.HeWeather6[0].update.utc; // utc time for update
				$("#updateTime").text(updateObj);
				$("#Temprature").text(temperature);
				$("#Wind").text(wind);
				for(var i=0;i<weatherCode.length;i++){	
					if (weatherCode[i][0] == citycode) {
						$("#Weather").text(weatherCode[i][1]); // set weather according to code;
						break;
					}
				}
			}, 
			error: function(data, status) {
				alert("error");	
			}			
		});	
	}
	
	$(function() {				
		$("#cityName").text('${weather.cityName}');
		var s = '${weather.cityName}';
		showWeatherInfo(s);
	});
	
</script>
</head>
<body>
<select id="city" name="city" onchange="change(this);">
	<c:forEach var="item" items="${cityList}" varStatus="status" >
         <option value="${item}">${item}</option> 
	</c:forEach>
</select>
<br>
<br>
<table border="1" id="weather">
<tr><td>city:</td><td id="cityName"></td></tr>
<tr><td>update time:</td><td id="updateTime"></td></tr>
<tr><td>Weather:</td><td id="Weather"></td></tr>
<tr><td>Temprature:</td><td id="Temprature"></td></tr>
<tr><td>Wind:</td><td id="Wind"></td></tr>
</table>
</body>
</html>