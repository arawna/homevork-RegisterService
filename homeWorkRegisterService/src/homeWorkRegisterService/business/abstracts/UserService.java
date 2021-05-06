package homeWorkRegisterService.business.abstracts;

import homeWorkRegisterService.entities.concretes.User;

public interface UserService {
	void register(User user,RegisterService registerService);
	void login(String email,String password);
	void verifyUser(User user);
}
