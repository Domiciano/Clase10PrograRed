package main;

import db.DbConnection;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        DbConnection db = new DbConnection();
        //db.runSQL("INSERT INTO students(name, code, age) VALUES ('Domiciano Rincon','A23234',30)");
        db.readTable();
        db.close();
    }
}
