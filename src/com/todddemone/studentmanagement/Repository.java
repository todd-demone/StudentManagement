package com.todddemone.studentmanagement;

import java.util.Map;
import java.util.HashMap;

public class Repository<T extends Identifiable> implements CrudRepository<T> {
	private Map<Integer, T> records = new HashMap<>();
	
	public T get(Integer id) {
		return records.get(id);
	}
	
	public void add(T item) {
		records.put(item.getId(), item);
	}
	
	public void remove(Integer id) {
		records.remove(id);
	}
}
