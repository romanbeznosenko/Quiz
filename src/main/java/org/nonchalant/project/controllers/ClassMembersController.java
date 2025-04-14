package org.nonchalant.project.controllers;

import org.nonchalant.project.entities.ClassMembers;
import org.nonchalant.project.services.ClassMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("class-members/")
public class ClassMembersController {
    @Autowired
    private ClassMembersService classMembersService;

    @GetMapping
    public Iterable<ClassMembers> getAllClassMembers(){
        return classMembersService.getAllClassMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassMembers> getClassMemebersById(@PathVariable Long id){
        return classMembersService.getClassMembersById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClassMembers addClassMembers(@RequestBody ClassMembers classMembers){
        return classMembersService.addClassMembers(classMembers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassMembers> updateClassMembers(@PathVariable Long id, @RequestBody ClassMembers classMembers){
        return classMembersService.updateClassMembers(id, classMembers)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassMembers(@PathVariable Long id){
        if (classMembersService.deleteClassMembers(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
