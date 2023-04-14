package org.maumont.api.repositories;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {

	List<T> list();

	void create(T t);

	Optional<T> getById(int id);

	void update(T t);

	void delete(int id);

}
