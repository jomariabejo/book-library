module com.CRUD{
    exports com.crud;
    exports com.create;
    exports com.delete;
    exports com.read;
    exports com.update;
    requires com.database;
    requires java.sql;
}