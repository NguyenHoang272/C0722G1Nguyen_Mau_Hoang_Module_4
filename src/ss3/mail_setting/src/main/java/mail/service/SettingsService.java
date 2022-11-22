package mail.service;

import mail.model.Settings;
import mail.repository.ISettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class SettingsService implements ISettingsService {

    @Autowired
    ISettingsRepository iSettingsRepository;

    @Override
    public List<String> finAllLanguages() {
        return iSettingsRepository.finAllLanguages();
    }

    @Override
    public List<Integer> finAllPageSize() {
        return iSettingsRepository.finAllPageSize();
    }

    @Override
    public List<Settings> finAllSettings() {
        return iSettingsRepository.finAllSettings();
    }

    @Override
    public void update(Settings settings) {
        iSettingsRepository.update(settings);

    }

    @Override
    public Settings findById(int id) {
        return iSettingsRepository.findById(id);
    }
}
