package com.crudbasics.juornalApp.contoller;

import com.crudbasics.juornalApp.entity.JournalEntery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private HashMap<Long, JournalEntery> journalEnteries = new HashMap<>();

    @GetMapping
    public ArrayList<JournalEntery> getAll() {
        return new ArrayList<>(journalEnteries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntery myEntry){
        journalEnteries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntery getJournalEntryById(@PathVariable Long myId) {
        return journalEnteries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntery deleteJournalEntryById(@PathVariable Long myId) {
        return  journalEnteries.remove(myId);
    }
    @PutMapping("id/{id}")
    public JournalEntery updateJournalById(@PathVariable Long id, @RequestBody JournalEntery myEntry){
        return journalEnteries.put(id, myEntry);
    }

}
