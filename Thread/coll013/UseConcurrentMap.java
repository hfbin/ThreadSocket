package cn.hfbin.coll013;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseConcurrentMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<String, Object>();
		chm.put("k1", "v1");
		chm.put("k2", "v2");
		chm.put("k3", "v3");

		//putIfAbsent  如果有相同的则不加  如果没有则加
		//chm.putIfAbsent("k3", "vvvv");
		chm.putIfAbsent("k4", "vvvv");
		System.out.println("k2 value = "+chm.get("k2"));
		System.out.println("总长度 = "+chm.size());
		
		for(Map.Entry<String, Object> me : chm.entrySet()){
			System.out.println("key:" + me.getKey() + ",value:" + me.getValue());
		}
		
	}
}
