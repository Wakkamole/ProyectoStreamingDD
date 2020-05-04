package iteso.mx.trash;



import java.sql.*;
import java.util.ArrayList;

public class BeginnerTrash implements Trash {
    /** String name. */
    String name = "";
    /** TrashLevel value. */
    String value = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name1) {
        this.name = name1;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value1) {
        this.value = value1;
    }

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
                String name = rs.getString("Name");
                String value = rs.getString("BeginnerValue");

                Trash tmpTrashObject = new BeginnerTrash();
                tmpTrashObject.setName(name);
                tmpTrashObject.setValue(value);

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
