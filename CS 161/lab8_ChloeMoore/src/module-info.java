module lab8_ChloeMoore {
	requires javafx.controls;
    requires javafx.graphics;

	opens application to javafx.graphics, javafx.fxml;
}
