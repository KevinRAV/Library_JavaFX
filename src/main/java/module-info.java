module com.coding.projectlibrary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.coding.projectlibrary to javafx.fxml;
    exports com.coding.projectlibrary;
}