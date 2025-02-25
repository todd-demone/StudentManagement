package com.todddemone.studentapp.repository;

import java.util.Set;

public interface CrudRepository<T> {

	void add(T item);

	T get(Integer id);

	void remove(Integer id);

	Set<T> getAll();
}
