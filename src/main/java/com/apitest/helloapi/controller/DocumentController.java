package com.apitest.helloapi.controller;


import com.apitest.helloapi.domain.Document;
import com.apitest.helloapi.repository.MemoryDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class DocumentController {

    MemoryDocumentRepository memoryDocumentRepository;

    @Autowired
    public DocumentController(MemoryDocumentRepository memoryDocumentRepository) {
        this.memoryDocumentRepository = memoryDocumentRepository;
    }

    @PostMapping("/post")
    public Document createDocument(@RequestBody Document document){
        memoryDocumentRepository.save(document);
        return document;
    }

    @GetMapping("/documents")
    public List<Document> allDocument(){
        return memoryDocumentRepository.findAll();
    }
    //
    @GetMapping("/post/{id}")
    public Document getById(@PathVariable Long id){
        Document result = memoryDocumentRepository.findById(id);
        return result;
    }

    @PutMapping("/put/{id}")
    public Document putById(@PathVariable Long id, @RequestBody Document document){
        Document result = memoryDocumentRepository.updateById(id, document);
        return result;
    }


//    @PostMapping
//    public String createCrew(@ModelAttribute("crew") CrewCreateDto crewCreateDto){
//        Crew crew = new Crew(crewCreateDto);
//        springDataJpaCrewRepository.save(crew);
//        return "crew/welcome";
//    }


    //test용도
    @PostConstruct
    public void init() {
        memoryDocumentRepository.save(new Document("doName1"));
        memoryDocumentRepository.save(new Document("doName2"));
    }
}
