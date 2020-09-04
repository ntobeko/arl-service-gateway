package za.co.africanrainbowlife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.africanrainbowlife.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
