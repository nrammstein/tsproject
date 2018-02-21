package ru.ts.bestteam.interfaces.dao;

import ru.ts.bestteam.entityobjects.Grade;

import java.sql.SQLException;
import java.util.Collection;

public interface GradeDao {
    void addGrade(Grade grade) throws SQLException;
    void deleteGrade(Grade grade) throws SQLException;
    Grade getGrade(Long id) throws SQLException;
    Grade getGrade(String name) throws SQLException;
    Collection<Grade> getGrades() throws SQLException;
    void updateGrade(Grade grade) throws SQLException;
}
