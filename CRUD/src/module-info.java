module com.CRUD{
    exports com.create;
    exports com.delete;
    exports com.read;
    exports com.update;
    requires com.GUI;
    requires com.database;
    requires java.sql;
    requires java.desktop;
}