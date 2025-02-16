module com.chess.labaratorywork3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.chess.labaratorywork3 to javafx.fxml;
    exports com.chess.labaratorywork3;

    opens com.chess.labaratorywork3.Engine to javafx.fxml;
    exports com.chess.labaratorywork3.Engine;

    opens com.chess.labaratorywork3.Figure to javafx.fxml;
    exports com.chess.labaratorywork3.Figure;
}