package com;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.model.JsonRootBean;
import com.model.Weather;

/**
 * weather service test
 * @author cs
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherCaseTest  { 
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

	
	@Test
	public void contextLoads() {
		String url = this.base.toString() + "/changeCity?cityName={1}";
		Weather weather = restTemplate.getForObject(url,Weather.class, "sydney");
		 System.out.println(String.format("测试结果为：%s", weather.getCityName()));  
	
	}
	
	/**
	 * this is a test for calling the real time weather interface using restTemplate of springboot
	 */
	@Test
	public void testWeatherApi() {
		 String url = "https://free-api.heweather.net/s6/weather/now?location={1}&key=956bc183fdf646b69a19a1c27ae2d501";
		 String str = restTemplate.getForObject(url, String.class, "Sydney");
         JSONObject resultObj = JSONObject.parseObject(str);
         JsonRootBean weather = JSONObject.toJavaObject(resultObj, JsonRootBean.class);
		 System.out.println(String.format("weather code：%s", weather.getHeWeather6().get(0).getNow().getCond_code()));
		 System.out.println(String.format("temperature：%s", weather.getHeWeather6().get(0).getNow().getTmp()));     
	}
	

}
