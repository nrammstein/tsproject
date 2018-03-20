package ru.ts.bestteam.interfaces.implementation;

import ru.ts.bestteam.entityobjects.Position;
import ru.ts.bestteam.interfaces.dao.PositionDao;

import java.sql.SQLException;
import java.util.Collection;

public class PositionDaoImpl implements PositionDao {
    @Override
    public void addPosition(Position position) throws SQLException {

    }

    @Override
    public void deletePosition(Position position) throws SQLException {

    }

    @Override
    public Position getPosition(Long id) throws SQLException {
        return null;
    }

    @Override
    public Position getPosition(String name) throws SQLException {
        return null;
    }

    @Override
    public Collection<Position> getPositions() throws SQLException {
        return null;
    }

    @Override
    public void updatePosition(Position position) throws SQLException {

    }
}
