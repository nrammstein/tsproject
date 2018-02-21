package ru.ts.bestteam.interfaces.dao;

import ru.ts.bestteam.entityobjects.Certificate;

import java.sql.SQLException;
import java.util.Collection;

public interface CertificateDao {
    void addCertificate(Certificate certificate) throws SQLException;
    void deleteCertificate( Certificate certificate) throws SQLException;
    Certificate getCertificate(Long id) throws SQLException;
    Collection<Certificate> getCertificates() throws SQLException;
    void updateCertificate(Certificate certificate) throws SQLException;
}
