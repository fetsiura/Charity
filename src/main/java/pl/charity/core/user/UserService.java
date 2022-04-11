package pl.charity.core.user;


public interface UserService {

    User findByEmail(String email);
    void saveUser(UserDto userDto);
}
