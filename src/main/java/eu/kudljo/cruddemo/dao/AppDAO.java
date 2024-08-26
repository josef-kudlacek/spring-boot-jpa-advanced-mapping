package eu.kudljo.cruddemo.dao;

import eu.kudljo.cruddemo.entity.Instructor;
import eu.kudljo.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
}
