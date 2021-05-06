package homeWorkRegisterService.core.abstracts;

import homeWorkRegisterService.entities.concretes.User;

public interface VerificationService {
	void sendVerify(User user);
}
