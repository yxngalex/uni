package ac.rs.metropolitan.it355dz06.service.impl;

import ac.rs.metropolitan.it355dz06.model.UsersTable;
import ac.rs.metropolitan.it355dz06.repository.UsersTableRepository;
import ac.rs.metropolitan.it355dz06.service.UsersTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersTableServiceImpl implements UsersTableService {
    private final UsersTableRepository usersTableRepository;

    @Override
    public List<UsersTable> findAll() {
        return usersTableRepository.findAll();
    }

    @Override
    public UsersTable findByUsername(String userName) {
        return usersTableRepository.findUsersTableByUsername(userName);
    }

    @Override
    public UsersTable save(UsersTable exam) {
        return usersTableRepository.save(exam);
    }

    @Override
    public UsersTable update(UsersTable exam) {
        return usersTableRepository.save(exam);
    }

    @Override
    public void deleteById(Integer examId) {
        usersTableRepository.deleteById(examId);
    }
}
