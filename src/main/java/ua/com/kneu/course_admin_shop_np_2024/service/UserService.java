package ua.com.kneu.course_admin_shop_np_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kneu.course_admin_shop_np_2024.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    public boolean getLogicUser(String username){
        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

}
