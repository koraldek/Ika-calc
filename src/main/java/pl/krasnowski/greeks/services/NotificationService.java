package pl.krasnowski.greeks.services;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
	void addInfoMessage(String msg);

	void addErrorMessage(String msg);
}
