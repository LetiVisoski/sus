module org.example.sus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.sus to javafx.fxml;
    exports org.example.sus;
}