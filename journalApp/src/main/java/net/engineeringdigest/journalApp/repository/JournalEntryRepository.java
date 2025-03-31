package net.engineeringdigest.journalApp.repository;


import net.engineeringdigest.journalApp.entries.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>
{

}
