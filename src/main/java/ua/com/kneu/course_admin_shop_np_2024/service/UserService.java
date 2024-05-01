package ua.com.kneu.course_admin_shop_np_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kneu.course_admin_shop_np_2024.entity.Clients;
import ua.com.kneu.course_admin_shop_np_2024.entity.Users;
import ua.com.kneu.course_admin_shop_np_2024.repository.ClientsRepository;
import ua.com.kneu.course_admin_shop_np_2024.repository.UsersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final ClientsRepository clientsRepository;

    public boolean getLogicUser(String username){
        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Not found!!");
        }

        return user;
    }

    public Clients getClientById(Long id){
        return clientsRepository.findById(id).get();
    }


    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public void updateUser(String password, String username, Long id){
        usersRepository.updateUserById(password, username, id);
    }

    public void addNewRoleToUser(Long userId, Long roleId){
        usersRepository.updateRoleByUserId(userId, roleId);
    }

}
