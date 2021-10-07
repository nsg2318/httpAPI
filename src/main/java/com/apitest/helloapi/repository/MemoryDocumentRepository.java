package com.apitest.helloapi.repository;


import com.apitest.helloapi.domain.Document;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryDocumentRepository {
    private static Map<Long, Document> store = new HashMap<>();
    private static Long sequence = 0L;

    public Document save(Document document) {
        document.setId(++sequence);
        store.put(document.getId(),document);
        return document;
    }

    public List<Document> findAll(){
        ArrayList<Document> result = new ArrayList<>(store.values());
        return result;
    }

    public Document findById(Long id){
        Document result = store.get(id);
        return result;
    }

    public Document updateById(Long id, Document document){
        Document findDocument = findById(id);
        findDocument.setName(document.getName());
        return findDocument;
    }

    public void deleteById(Long id){
        store.remove(id);
    }

}
