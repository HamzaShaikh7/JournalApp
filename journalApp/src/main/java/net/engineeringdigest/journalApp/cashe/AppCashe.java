package net.engineeringdigest.journalApp.cashe;


import net.engineeringdigest.journalApp.entries.ConfigJournalAppEntry;
import net.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCashe
{

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;


    public Map<String ,String > APP_CASHE = new HashMap<>();


    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntry> all = configJournalAppRepository.findAll();
        for (ConfigJournalAppEntry configJournalAppEntry : all){
            APP_CASHE.put(configJournalAppEntry.getKey(), configJournalAppEntry.getValue());
        }
        APP_CASHE = null;
    }
}
