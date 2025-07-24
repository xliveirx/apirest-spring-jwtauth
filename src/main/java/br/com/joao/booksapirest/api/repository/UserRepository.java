package br.com.joao.booksapirest.api.repository;

import br.com.joao.booksapirest.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
