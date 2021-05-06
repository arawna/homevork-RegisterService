package homeWorkRegisterService.dataAccess.abstracts;

import java.util.List;

import homeWorkRegisterService.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void updateEmail(User user,String newEmail);
	User getUserById(int id);
	User getUserByEmail(String email);
	List<User> getAllUsers();
	boolean isEmailUnUsing(String email);
	void verifyUser(User user);
	
}
