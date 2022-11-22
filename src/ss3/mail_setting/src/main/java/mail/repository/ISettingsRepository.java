package mail.repository;

import mail.model.Settings;

import java.util.List;

public interface ISettingsRepository {
    List<String> finAllLanguages();
    List<Integer> finAllPageSize();
    List<Settings> finAllSettings();
    void update(Settings settings);
    Settings findById(int id);
}
