module project3_ChloeMoore {
	requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;

	opens application to javafx.graphics, javafx.fxml;
}
