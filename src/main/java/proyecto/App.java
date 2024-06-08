package proyecto;

import javafx.event.EventHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import proyecto.components.MakeColor;

/**
 * JavaFX App
 */
public class App extends Application {

    public String color_escogido;
    public String fecha_escogida;
    private Stage segundaVentana;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {

        MakeColor make_box = new MakeColor();
        ColoresAgregadors new_scene = new ColoresAgregadors();

        // ! crear nodo padre
        AnchorPane root = new AnchorPane(); // 800px x 700px
        VBox box_1 = new VBox();
        Label txt_seleccion_colores = new Label("Seleccionar Colores");
        Label txt_escoge_color = new Label("Escoge un color: ");
        Label txt_escoge_fecha = new Label("Selecciona una fecha: ");

        // ?Colores

        VBox box_2 = new VBox();
        box_2.setPrefSize(100, 250);
        box_2.getStyleClass().addAll("box_2");

        // generando colores
        Pane caja_1 = make_box.make_color("color-red");
        Pane caja_2 = make_box.make_color("color-blue");
        Pane caja_3 = make_box.make_color("color-green");
        Pane caja_4 = make_box.make_color("color-cyan");

        // generando accion al tocar un color
        EventHandler<MouseEvent> nodeClickHandler = event -> {
            Pane clickedPane = (Pane) event.getSource();
            String cssClass = clickedPane.getStyleClass().get(0);
            this.color_escogido = cssClass;
            System.out.println(cssClass);
        };

        // agregando accion
        caja_1.setOnMouseClicked(nodeClickHandler);
        caja_2.setOnMouseClicked(nodeClickHandler);
        caja_3.setOnMouseClicked(nodeClickHandler);
        caja_4.setOnMouseClicked(nodeClickHandler);

        // ? Fecha
        DatePicker datePicker = new DatePicker();

        datePicker.setOnAction(event -> {
            // obtener fecha
            LocalDate selectedDate = datePicker.getValue();
            // fecha a string formateado
            String fecha = selectedDate.format(DateTimeFormatter.ofPattern("yy-MM-dd"));
            this.fecha_escogida = fecha;
            System.out.println(fecha);
        });

        // ? Agregar
        Button btn_add = new Button("Agregar");
        btn_add.setOnMouseClicked(event -> {
            this.segundaVentana = new_scene.mostrar_colores_agregados(color_escogido, fecha_escogida);
            segundaVentana.show();

        });

        // Agregando
        box_2.getChildren().addAll(caja_1, caja_2, caja_3, caja_4);
        box_2.setAlignment(Pos.CENTER);
        box_1.getChildren().addAll(txt_seleccion_colores, txt_escoge_color, box_2, txt_escoge_fecha, datePicker,
                btn_add);
        box_1.setAlignment(Pos.CENTER);
        root.getChildren().addAll(box_1);

        // Anclaje
        AnchorPane.setTopAnchor(box_1, 5.0);
        AnchorPane.setLeftAnchor(box_1, 5.0);
        AnchorPane.setRightAnchor(box_1, 5.0);
        AnchorPane.setBottomAnchor(box_1, 5.0);

        // creando escenario
        Scene scene = new Scene(root, 250, 400);
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
        stage.setTitle("Selección de Colores");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}