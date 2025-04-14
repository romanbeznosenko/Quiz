package org.nonchalant.project.services;

import org.nonchalant.project.entities.Class;
import org.nonchalant.project.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public Iterable<Class> getAllClasses(){
        return classRepository.findAll();
    }

    public Optional<Class> getClassById(Long id){
        return classRepository.findById(id);
    }

    public Class createClass(Class classE){
        return classRepository.save(classE);
    }

    public Optional<Class> updateUser(Long id, Class classE){
        return classRepository.findById(id)
                .map(existingClass -> {
                    existingClass.setName(classE.getName());
                    existingClass.setCode(classE.getCode());
                    existingClass.setTeacher(classE.getTeacher());
                    return existingClass;
                });
    }

    public boolean deleteClass(Long id){
        if (classRepository.existsById(id)){
            classRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
