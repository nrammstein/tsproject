package ru.ts.bestteam.interfaces.implementation;

import org.hibernate.Session;
import ru.ts.bestteam.HibernateUtil;
import ru.ts.bestteam.entityobjects.Grade;
import ru.ts.bestteam.interfaces.dao.GradeDao;

import java.sql.SQLException;
import java.util.Collection;

public class GradeDaoImpl implements GradeDao {
    @Override
    public void addGrade(Grade grade) throws SQLException {

    }

    @Override
    public void deleteGrade(Grade grade) throws SQLException {

    }

    @Override
    public Grade getGrade(Long id) throws SQLException {
       return null;
    }

    @Override
    public Grade getGrade(String name) throws SQLException {
        return null;
    }

    @Override
    public Collection<Grade> getGrades() throws SQLException {
        return null;
    }

    @Override
    public void updateGrade(Grade grade) throws SQLException {

    }
}
