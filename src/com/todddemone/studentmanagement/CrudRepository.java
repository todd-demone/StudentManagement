package com.todddemone.studentmanagement;

public interface CrudRepository<T> {
	T get(Integer id);
	void add(T item);
	void remove(Integer id);
}
