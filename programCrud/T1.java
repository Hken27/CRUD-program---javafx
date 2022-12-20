package programCrud;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class T1 extends Application  {
    public static class Mahasiswa{
        private final SimpleStringProperty name, mataKuliah, waktu, gkb, ruangan;

        private Mahasiswa(String a, String b, String c, String d, String e) {
            this.name = new SimpleStringProperty(a);
            this.mataKuliah = new SimpleStringProperty(b);
            this.waktu = new SimpleStringProperty(c);
            this.gkb = new SimpleStringProperty(d);
            this.ruangan = new SimpleStringProperty(e);
            
        }

        public void setName(String a) {name.set(a);}
        public String getName() { return name.get(); }
        public void setMataKuliah(String a) {mataKuliah.set(a);}
        public String getMatakuliah(){ return mataKuliah.get(); }
        public void setWaktu(String a) {waktu.set(a);}
        public String getWaktu(){ return waktu.get(); }
        public void setGKB(String a) {gkb.set(a);}
        public String getGkb() { return gkb.get(); }
        public void setRuangan(String a) {ruangan.set(a);}
        public String getRuangan() { return ruangan.get(); }

    }

    final ObservableList<Mahasiswa> data = FXCollections.observableArrayList();
    private int selectedIndex = -1;
    TableView<Mahasiswa> table = new TableView<>();    

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("KOMTOLODON");
        DropShadow dp = new DropShadow();
        final VBox vbox = new VBox();
        final VBox vbox2 = new VBox();
        final HBox hb = new HBox();
        final HBox hb2 = new HBox();
        vbox.setStyle("-fx-background-color:#E0FFFF");
        vbox2.setStyle("-fx-background-color:#E0FFFF");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(new Group());
        Scene scene2 = new Scene(new Group());
        final Label label1 = new Label("WELCOME HOOO");
        final Label label = new Label("  JADWAL MAHASISWA KULI-AH  ");
        label1.setFont(new Font("Arial Black",25));
        label.setFont(new Font("Agency FB", 35));
        dp.setColor(Color.DARKSLATEGREY);
        label1.setEffect(dp);
        TableColumn ColName = new TableColumn("NAMA");
        TableColumn ColMataKuliah = new TableColumn("MATKUL");
        TableColumn ColWaktu = new TableColumn("JAM");
        TableColumn ColGKB = new TableColumn("GKB");
        TableColumn ColRuangan = new TableColumn("RUANGAN");
        ColName.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("name"));
        ColMataKuliah.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("matakuliah"));
        ColWaktu.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("waktu"));
        ColGKB.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("gkb"));
        ColRuangan.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("Ruangan"));

        ColName.setCellFactory(TextFieldTableCell.forTableColumn());
        ColMataKuliah.setCellFactory(TextFieldTableCell.forTableColumn());
        ColWaktu.setCellFactory(TextFieldTableCell.forTableColumn());
        ColGKB.setCellFactory(TextFieldTableCell.forTableColumn());
        ColRuangan.setCellFactory(TextFieldTableCell.forTableColumn());

        ColName.setOnEditCommit((EventHandler<CellEditEvent<Mahasiswa, String>>) t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue()));
        ColMataKuliah.setOnEditCommit((EventHandler<CellEditEvent<Mahasiswa, String>>) t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setMataKuliah(t.getNewValue()));
        ColWaktu.setOnEditCommit((EventHandler<CellEditEvent<Mahasiswa, String>>) t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setWaktu(t.getNewValue()));
        ColGKB.setOnEditCommit((EventHandler<CellEditEvent<Mahasiswa, String>>) t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setGKB(t.getNewValue()));
        ColRuangan.setOnEditCommit((EventHandler<CellEditEvent<Mahasiswa, String>>) t -> t.getTableView().getItems().get(t.getTablePosition().getRow()).setRuangan(t.getNewValue()));
        
        
        table.setEditable(true);
        table.setItems(data);
        table.getColumns().addAll(ColName,ColMataKuliah, ColWaktu, ColGKB,  ColRuangan);
        table.setOnMouseClicked(event -> selectedIndex = table.getSelectionModel().getSelectedIndex());
        final TextField fieldNama = new TextField();
        final TextField fieldMataKuliah = new TextField();
        final TextField fieldWaktu = new TextField();
        final TextField fieldGKB = new TextField();
        final TextField fieldRuangan = new TextField();
        
        fieldNama.setPromptText("DOSEN");
        fieldMataKuliah.setPromptText("MATA KULIAH");
        fieldWaktu.setPromptText("JAM");
        fieldGKB.setPromptText("GKB");
        fieldRuangan.setPromptText("RUANGAN");
        Button LihatJadwal = new Button ("Lihat Jadwal");
        LihatJadwal.setStyle("-fx-background-color: transparent");
        Button Delete = new Button("Hapus");
        Delete.setStyle("-fx-background-color: transparent");
        Button Back = new Button("Kembali");
        Back.setStyle("-fx-background-color: transparent");
        Button Add = new Button("Tambah");
        Add.setStyle("-fx-background-color: transparent");
        
        Delete.setOnAction((ActionEvent e) -> data.remove(selectedIndex));
        LihatJadwal.setOnAction(e -> primaryStage.setScene(scene2));
        Back.setOnAction((e -> primaryStage.setScene(scene)));
        Add.setOnAction(e -> {
            int jika = 0, kalau = 0, k = 0;
            if(fieldNama.getText().trim().isEmpty()){ jika++;}
            if(fieldGKB.getText().trim().isEmpty()){ jika++;}
            if(fieldMataKuliah.getText().trim().isEmpty()){ jika++;}
            if(fieldRuangan.getText().trim().isEmpty()){ jika++;}
            if(fieldWaktu.getText().trim().isEmpty()){jika++;}
            if(fieldGKB.getText().matches("[0-9]*")){kalau++;}
            if(fieldWaktu.getText().matches("[0-9.]*")){k++;}
            if(jika != 0){
                Alert fail= new Alert(AlertType.ERROR);
                fail.setHeaderText("404 not found");
                fail.setContentText("Data WAJIB TULISAN");
                fail.showAndWait();
            } else if(kalau ==0){
                Alert fail= new Alert(AlertType.ERROR);
                fail.setHeaderText("404 not found");
                fail.setContentText("DATA wAJIB ANGKA");
                fail.showAndWait();
            }else if (k ==0) {
                Alert fail= new Alert(AlertType.ERROR);
                fail.setHeaderText("404 not found");
                fail.setContentText("DATA wAJIB ANGKA");
                fail.showAndWait();
            }else {
                data.add(
                        new Mahasiswa(
                                fieldNama.getText(),
                                fieldMataKuliah.getText(),
                                fieldWaktu.getText(),
                                fieldGKB.getText(),
                                fieldRuangan.getText()
                        )

                );
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Horre");
                alert.setContentText("Mantep");
                alert.showAndWait();

                fieldNama.clear();
                fieldMataKuliah.clear();
                fieldWaktu.clear();
                fieldGKB.clear();
                fieldRuangan.clear();
            }});
        hb.setSpacing(15);
        hb.setPadding(new Insets(25, 25, 25, 25));
        hb.getChildren().addAll(Add, LihatJadwal);
        vbox2.setSpacing(15);
        vbox2.setPadding(new Insets(40, 35, 80, 35));
        vbox2.getChildren().addAll(label1,fieldNama, fieldMataKuliah, fieldWaktu, fieldGKB, fieldRuangan, hb);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 17, 25, 17));
        vbox.getChildren().addAll(label, table, Back, Delete);

        ((Group) scene.getRoot()).getChildren().addAll(vbox2);
        ((Group) scene2.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
        
    }
    
}