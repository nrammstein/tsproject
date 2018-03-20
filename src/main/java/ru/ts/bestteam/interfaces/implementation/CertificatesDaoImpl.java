package ru.ts.bestteam.interfaces.implementation;

import ru.ts.bestteam.entityobjects.Certificate;
import ru.ts.bestteam.interfaces.dao.CertificateDao;

import java.sql.SQLException;
import java.util.Collection;

public class CertificatesDaoImpl implements CertificateDao {
    @Override
    public void addCertificate(Certificate certificate) throws SQLException {

    }

    @Override
    public void deleteCertificate(Certificate certificate) throws SQLException {

    }

    @Override
    public Certificate getCertificate(Long id) throws SQLException {
        return null;
    }

    @Override
    public Collection<Certificate> getCertificates() throws SQLException {
        return null;
    }

    @Override
    public void updateCertificate(Certificate certificate) throws SQLException {

    }
}
