package com.biyouche.utils;

import java.util.ArrayList;
import java.util.List;


public class ArrToList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List arrtoList(String[] split) {
		List an = new ArrayList();
		for(int i=0;i<split.length;i++) {
			an.add(split[i]);
		}
		return an;
	}
}
