package homeWorkRegisterService.core.concretes;

import homeWorkRegisterService.core.abstracts.VerificationService;
import homeWorkRegisterService.entities.concretes.User;

public class EmailVerification implements VerificationService{
	public void sendVerify(User user) {
		System.out.println("Email Service: Mail sended "+user.getEmail());
	}
}
