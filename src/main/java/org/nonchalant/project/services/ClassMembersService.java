package org.nonchalant.project.services;

import org.nonchalant.project.entities.ClassMembers;
import org.nonchalant.project.repositories.ClassMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassMembersService {
    @Autowired
    private ClassMembersRepository classMembersRepository;

    public Iterable<ClassMembers> getAllClassMembers(){
        return classMembersRepository.findAll();
    }

    public Optional<ClassMembers> getClassMembersById(Long id){
        return classMembersRepository.findById(id);
    }

    public ClassMembers addClassMembers(ClassMembers classMembers){
        return classMembersRepository.save(classMembers);
    }

    public Optional<ClassMembers> updateClassMembers(Long id, ClassMembers classMembers){
        return classMembersRepository.findById(id)
                .map(existsingMember -> {
                    existsingMember.setClassEntity(classMembers.getClassEntity());
                    existsingMember.setUser(classMembers.getUser());
                    return classMembersRepository.save(existsingMember);
                });
    }

    public boolean deleteClassMembers(Long id){
        if (classMembersRepository.existsById(id)){
            classMembersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
