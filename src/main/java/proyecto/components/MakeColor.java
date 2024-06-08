package proyecto.components;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MakeColor {

	public Pane make_color(String color) {
		Pane caja = new Pane();
		caja.setPrefSize(50, 50);
		caja.getStyleClass().addAll(color);

		return caja;
	}

	public HBox make_color_selected(String color, String fecha) {
		HBox caja = new HBox(5);
		caja.setPrefSize(200, 50);

		Pane caja_color = new Pane();
		caja_color.setPrefSize(120, 30);

		caja_color.getStyleClass().addAll(color);
		Label txt_fecha = new Label("Fecha: " + fecha);

		caja.getChildren().addAll(caja_color, txt_fecha);
		caja.getStyleClass().addAll("box_1");
		return caja;

	}

}
