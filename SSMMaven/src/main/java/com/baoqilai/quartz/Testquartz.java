package com.baoqilai.quartz;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Testquartz {

	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次  
    public void testQuartz(){
		System.out.println(new Date().getTime());
	}
	
}
