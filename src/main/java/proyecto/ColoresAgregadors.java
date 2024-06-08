package proyecto;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import proyecto.components.MakeColor;

public class ColoresAgregadors {

	@SuppressWarnings("exports")
	public ArrayList<HBox> lista_HBox;
	private MakeColor making_color;

	public ColoresAgregadors() {
		this.lista_HBox = new ArrayList<>();
		this.making_color = new MakeColor();
	}

	@SuppressWarnings("exports")
	public Stage mostrar_colores_agregados(String color, String fecha) {

		// Nodo Padre
		AnchorPane root = new AnchorPane();

		// Nodo hijo
		VBox box_1 = new VBox(5);
		/* box_1.setPrefSize(250, 150); */
		box_1.getStyleClass().addAll("box_1");

		// Colores

		// Agregando
		add_lista_colores(color, fecha);
		for (HBox Hcaja : lista_HBox) {
			box_1.getChildren().addAll(Hcaja);
		}

		// Envolviendo box_1 en un ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(box_1);
		scrollPane.setFitToWidth(true);
		scrollPane.setPrefViewportHeight(100); // Altura del área visible del ScrollPane
		scrollPane.setPrefViewportWidth(200); // Ancho del área visible del ScrollPane

		root.getChildren().addAll(scrollPane);

		AnchorPane.setTopAnchor(scrollPane, 15.0);
		AnchorPane.setBottomAnchor(scrollPane, 15.0);
		AnchorPane.setLeftAnchor(scrollPane, 15.0);
		AnchorPane.setRightAnchor(scrollPane, 15.0);

		// generando nueva ventana
		Stage stage = new Stage();
		stage.setTitle("Colores Agregados");
		Scene scene = new Scene(root, 300, 200);
		scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
		stage.setScene(scene);

		return stage;

	}

	public void add_lista_colores(String color, String fecha) {
		HBox caja = making_color.make_color_selected(color, fecha);
		lista_HBox.add(caja);

	}

}
