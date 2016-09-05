package com.epam.task.util;

import java.util.Random;

public class ConfirmCodeGenerator {
	public String getCode(){
		Integer temp;
		do {
			temp = new Random().nextInt(10000000);
			if (temp >= 1000000)
				break;
		} while (true);
		return temp.toString();
	}

}
