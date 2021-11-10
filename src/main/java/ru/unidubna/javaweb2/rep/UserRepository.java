package ru.unidubna.javaweb2.rep;

import org.springframework.data.repository.CrudRepository;
import ru.unidubna.javaweb2.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
