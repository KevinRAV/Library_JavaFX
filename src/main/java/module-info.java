module com.coding.projectlibrary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.coding.projectlibrary to javafx.fxml;
    exports com.coding.projectlibrary;
    exports com.coding.projectlibrary.controller;
    opens com.coding.projectlibrary.controller to javafx.fxml;
    exports com.coding.projectlibrary.model;
    opens com.coding.projectlibrary.model to javafx.fxml;
}