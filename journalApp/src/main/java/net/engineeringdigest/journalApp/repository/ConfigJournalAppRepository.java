package net.engineeringdigest.journalApp.repository;


import net.engineeringdigest.journalApp.entries.ConfigJournalAppEntry;
import net.engineeringdigest.journalApp.entries.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntry, ObjectId>
{

}
