package ifksp.service;

import ifksp.dto.CreateUserCommand;
import ifksp.dto.UpdateUserCommand;
import ifksp.dto.UserDto;
import ifksp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ifksp.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getUsers() {
//        List<User> users = userRepository.findAll();
        List<User> users = userRepository.findAllByOrderByIdAsc();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).toList();
    }

    public List<UserDto> addUser(CreateUserCommand command) {
        User user = new User(command.getFirst(), command.getLast(), command.getHandle());
        userRepository.save(user);
        return getUsers();
    }

    public List<UserDto> updateUser(Long id, UpdateUserCommand command) {
        User user = userRepository.findById(id).get();
        user.setFirst(command.getFirst());
        user.setLast(command.getLast());
        user.setHandle(command.getHandle());
        return getUsers();
    }

    public List<UserDto> deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return getUsers();
    }
}
