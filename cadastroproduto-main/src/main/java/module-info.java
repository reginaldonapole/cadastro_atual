module com.papelariaencantada.cadastroproduto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.papelariaencantada.cadastroproduto to javafx.fxml;
    exports com.papelariaencantada.cadastroproduto;
}
