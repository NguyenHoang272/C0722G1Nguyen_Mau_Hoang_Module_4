package mail.repository;

import mail.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingsRepository implements ISettingsRepository {
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> size = new ArrayList<>();
    private static List<Settings> settingsList = new ArrayList<>();


    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        size.add(5);
        size.add(15);
        size.add(25);
        size.add(50);
        size.add(100);

        settingsList.add(new Settings(1,"English",5,true,"Hoang"));
        settingsList.add(new Settings(2,"Vietnamese",10,true,"Hoang"));
        settingsList.add(new Settings(3,"Japanese",25,false,"Hoang"));
        settingsList.add(new Settings(4,"Chinese",50,true,"Hoang"));
    }

    @Override
    public List<String> finAllLanguages() {
        return languages;
    }

    @Override
    public List<Integer> finAllPageSize() {
        return size;
    }

    @Override
    public List<Settings> finAllSettings() {
        return settingsList;
    }

    @Override
    public void update(Settings settings) {
        for(Settings setting : settingsList){
            if(settings.getId()==setting.getId()){
                setting.setLanguages(settings.getLanguages());
                setting.setPageSize(settings.getPageSize());
                setting.setSignature(settings.getSignature());
                setting.setSpamsFilter(settings.isSpamsFilter());
                return;
            }
        }
    }

    @Override
    public Settings findById(int id) {
        for (Settings settings:settingsList) {
            if(settings.getId()==id) {
                return settings;
            }
        return settings;
    }
        return null;
    }
}
