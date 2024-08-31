package org.dubhe.javolution.pool;

import com.teradata.jdbc.TeraDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class PalDataSource extends TeraDataSource
{
    public PalDataSource() {
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException
    {
        this.setDatabaseName("palworld");
        this.setDescription("PalWorld Database");
        this.setServerName("ctf");
        this.setLoginTimeout(3);
        this.setDSName("127.0.0.1");
        return super.getConnection(username, password);
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        return null;
    }
}
