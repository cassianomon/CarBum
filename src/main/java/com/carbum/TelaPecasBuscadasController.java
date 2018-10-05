package com.carbum;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.apache.log4j.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.carbum.TelaCadastroPecaController.decodeToImage;

public class TelaPecasBuscadasController implements Initializable{
    public TextField inputTermoBusca;
    public Button btBuscar;
    public Button btVenderPeca;
    public Button btMinhaConta;
    public GridPane pecasBuscadas = new GridPane();
    public Button button;
    public ScrollPane scrollPane;
    public static String pecaBuscada;

    @FXML
    AnchorPane rootPane;

    private ConexaoBanco conexao;
    private String sql;

    public TelaPecasBuscadasController()throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.conexao = new ConexaoBanco();
    }

    public ConexaoBanco getConexao() {
        return conexao;
    }

    public void buscar(ActionEvent actionEvent) {

        try {
            TelaInicialController.pecaBuscada = inputTermoBusca.getText();
            AnchorPane telaPecaPesquisas = (AnchorPane) FXMLLoader.load(getClass()
                    .getResource("/fxml/TelaPecasBuscadas.fxml"));

            rootPane.getChildren().setAll(telaPecaPesquisas);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void vender(ActionEvent actionEvent) {

    }

    public void conta(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        scrollPane.setFitToWidth(true);

        try {

            sql = "SELECT partecarro, nomecarro, marcacarro, ano, modelo, conservacao, preco, imagem1 FROM anuncio WHERE partecarro ~* ?";
            PreparedStatement pstatement = conexao.getConnection().prepareStatement(sql);
            pstatement.setString(1, TelaInicialController.pecaBuscada);
            ResultSet rs = pstatement.executeQuery();
            int contC = 0, contR = 0;
            while (rs.next()){
                String partecarro = rs.getString("partecarro");
                String nomecarro = rs.getString("nomecarro");
                String marcacarro = rs.getString("marcacarro");
                String ano = rs.getString("ano");
                String modelo = rs.getString("modelo");
                String conservacao = rs.getString("conservacao");
                String preco = rs.getString("preco");
                String imagem = rs.getString("imagem1");

                BufferedImage bufferedImage = decodeToImage(imagem);
                Image card = SwingFXUtils.toFXImage(bufferedImage, null );

                ImageView imageView = new ImageView(card);

                imageView.setFitWidth(310);
                imageView.setFitHeight(250);

                Label titulo = new Label(partecarro + " " + nomecarro + " " + marcacarro + " "
                    + ano + "/" + modelo + " em um " + conservacao + " estado");

                titulo.setWrapText(true);
                titulo.setFont(Font.font(10));
                titulo.setTextAlignment(TextAlignment.LEFT);

                Label valor = new Label("R$" + preco);
                valor.setStyle("-fx-background-color: orange");
                valor.setFont(Font.font(20));

                VBox vBox = new VBox(imageView, titulo, valor);

                vBox.setSpacing(10);
                vBox.setAlignment(Pos.TOP_LEFT);
                //vBox.setStyle("-fx-border-color: black");
                vBox.setStyle("-fx-background-color: darkgray");
                vBox.setPrefHeight(800);
                //pecasBuscadas.addRow(contR, vBox);
                pecasBuscadas.add(vBox, contC, contR);
                //pecasBuscadas.getRowConstraints().get(0).setPrefHeight(400);
                contC++;
                if (contC > 2){
                    contC = 0;
                    contR++;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
