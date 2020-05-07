package iteso.mx.trash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * IntermediateTrash Class implements Trash.
 */
public class IntermediateTrash implements Trash {

    /** String name. */
    private String name = "";
    /** TrashLevel value. */
    private String value = null;

    /**
     * getName method.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * setName method.
     * @param name1 .
     */
    @Override
    public void setName(final String name1) {
        this.name = name1;
    }

    /**
     * getValue method.
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * setValue method.
     * @param value1 .
     */
    @Override
    public void setValue(final String value1) {
        this.value = value1;
    }

    /**
     * loadTash method.
     * @return tmpTrash.
     */
    @Override
    public ArrayList<Trash> loadTrash() {
        ArrayList<Trash> tmpTrash = new ArrayList<Trash>();

        try {
            String host = "jdbc:mysql://localhost:3306/project";
            String uName = "root";
            String uPass = "welcome1";
            Connection con = DriverManager.getConnection(
                    host, uName, uPass);

            Statement stat = con.createStatement();
            String query = "SELECT * FROM project.trash2";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {

                //int id = rs.getInt("ID");
                String name2 = rs.getString("Name");
                String value2 = rs.getString("IntermediateValue");

                Trash tmpTrashObject = new IntermediateTrash();
                tmpTrashObject.setName(name2);
                tmpTrashObject.setValue(value2);

                tmpTrash.add(tmpTrashObject);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        System.out.println(
                "Succesfully loaded all the objects from the database");

        return tmpTrash;
    }
}
