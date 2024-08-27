package eu.kudljo.cruddemo.dao;

import eu.kudljo.cruddemo.entity.Course;
import eu.kudljo.cruddemo.entity.Instructor;
import eu.kudljo.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int instructorId);

    Instructor findInstructorByInstructorIdJoinFetch(int instructorId);
}
