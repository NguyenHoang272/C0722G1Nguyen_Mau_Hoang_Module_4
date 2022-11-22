package mail.service;

import mail.model.Settings;

import java.util.List;

public interface ISettingsService {
    List<String> finAllLanguages();
    List<Integer> finAllPageSize();
    List<Settings> finAllSettings();
    void update(Settings settings);
    Settings findById(int id);
}
