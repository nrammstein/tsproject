package ru.ts.bestteam.interfaces.dao;

import ru.ts.bestteam.entityobjects.Position;

import java.sql.SQLException;
import java.util.Collection;

public interface PositionDao {
    void addPosition(Position position) throws SQLException;
    void deletePosition(Position position) throws SQLException;
    Position getPosition(Long id) throws SQLException;
    Position getPosition(String name) throws SQLException;
    Collection<Position> getPositions() throws SQLException;
    void updatePosition(Position position) throws SQLException;
}
