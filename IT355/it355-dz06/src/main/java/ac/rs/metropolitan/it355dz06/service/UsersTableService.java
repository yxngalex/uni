package ac.rs.metropolitan.it355dz06.service;

import ac.rs.metropolitan.it355dz06.model.UsersTable;

import java.util.List;

public interface UsersTableService {

    List<UsersTable> findAll();

    UsersTable findByUsername(String userName);

    UsersTable save(UsersTable exam);

    UsersTable update(UsersTable exam);

    void deleteById(Integer examId);

}
