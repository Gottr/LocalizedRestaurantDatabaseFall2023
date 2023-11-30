module com.example.majorprogrammingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.majorprogrammingproject to javafx.fxml;
    exports com.example.majorprogrammingproject;
    exports com.example.majorprogrammingproject.defaults;
    opens com.example.majorprogrammingproject.defaults to javafx.fxml;
}