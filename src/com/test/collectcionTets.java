package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

public class collectcionTets {
	public static void main(String[] args) {
		//����Ϊ���ϵ�ͬ������(�̰߳�ȫ)
		
		Collection c=Collections.synchronizedCollection(new ArrayList());
		List arr=Collections.synchronizedList(new ArrayList());
		Set s=Collections.synchronizedSet(new HashSet());
		Map m=Collections.synchronizedMap(new HashMap());
	}
}
