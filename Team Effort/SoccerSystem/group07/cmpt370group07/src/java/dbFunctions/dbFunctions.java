/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbFunctions;

import Connection.ConnectionManager;
import java.sql.*;
import java.util.*;

/**
 *
 * @author srw565
 */
public class dbFunctions {

    private Connection db;
    private Statement st;

    /**
     * Initialize the class fields.
     */
    public dbFunctions() {

        try {
            db = ConnectionManager.getConnection();
            st = db.createStatement();
        } catch (SQLException ex) {
            System.out.println("DB open exception\n");
            System.exit(1);
        }
    }

    /**
     * get information from the data base using a sql command
     * @param sql - sql command (ex. SELECT * FROM...)
     * @return a vector containing the output of the database query
     */
    public Vector getRecord(String sql) {
        try {
            ResultSet dbrs = st.executeQuery(sql);

            if (!dbrs.next()) {
                return null;
            }

            Vector rows = new Vector();
            ResultSetMetaData dbrsmd = dbrs.getMetaData();
            do {
                rows.addElement(getNextRow(dbrs, dbrsmd));
            } while (dbrs.next());

            return rows;
        } catch (SQLException ex) {
            return null;
        }
    }

    /**
     * Used by getRecord to query the database
     * @throws SQLException 
     */
    private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd)
            throws SQLException {
        Vector curRow = new Vector();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            curRow.addElement(rs.getString(i));
        }
        return curRow;
    }

    public void shutdown() {
        try {
            st.close();
            db.close();
        } catch (SQLException e) {
            System.err.println("Unable to close the DB Connection");
            e.printStackTrace();
        }
    }

    protected void finalize() {
        if (db != null) {
            shutdown();
        }
    }
}
