package ac.rs.metropolitan.it355dz06.repository;

import ac.rs.metropolitan.it355dz06.model.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTableRepository extends JpaRepository<UsersTable, Integer> {
    UsersTable findUsersTableByUsername(String userName);
}
