package br.senai.sp.jandira.tabuada.gui;

import br.senai.sp.jandira.tabuada.model.Usuario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TelaTabuada extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        // Setar tamanho, altura e largura da tela.

        //stage.setWidth(500);
        //stage.setHeight(500);
        stage.setTitle("Tabuada");
        stage.setResizable(false);

        // Criar o root - componente de leitute principal
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #cae7d5;");

        // Criamos a cena e colocamos o ROOT nela
        Scene scene = new Scene(root);

        // Criar header da tela
        VBox header = new VBox();
        //header.setPrefHeight(100);
        header.setStyle("-fx-background-color: #651ce1;");

        // Colocar o conteudo do header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setPadding(new Insets(8,0,0,8));
        Label labelSubtitulo = new Label("Crie a tabuada que sua imaginação mandar.");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 40;-fx-font-weight: bold;");

        Label labelTexto = new Label("Criar a tabuada que a sua imaginação");
        labelSubtitulo.setPadding(new Insets(0,0,8,8));
        labelTexto.setStyle("-fx-text-fill: white;");

        //Colocar as labels dentro do header
        header.getChildren().addAll(labelTitulo,labelSubtitulo);


        // Criar o grid de formulário
        GridPane gridFormulario = new GridPane();
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(8,8,8,8));
        //gridFormulario.setPrefHeight(100);
        //gridFormulario.setStyle("-fx-background-color: #4a87e3;");

        // Criar o conteudo do gridFormulario
        Label labelMultiplicando = new Label("Multiplicando: ");
        TextField textFieldMultiplicando = new TextField();

        Label labelMenorMultiplicador = new Label("MenorMultiplicador: ");
        TextField textFieldMenorMultiplicador = new TextField();

        Label labelMaiorMultiplicador = new Label("MaiorMultiplicador: ");
        TextField textFieldMaiorMultiplicador = new TextField();

        //Colocar os componentes no grid
        gridFormulario.add(labelMultiplicando,0,0);
        gridFormulario.add(textFieldMultiplicando,1,0);
        gridFormulario.add(labelMenorMultiplicador,0,1);
        gridFormulario.add(textFieldMenorMultiplicador,1,1);
        gridFormulario.add(labelMaiorMultiplicador,0,2);
        gridFormulario.add(textFieldMaiorMultiplicador,1,2);

        // Criar a caixa dos botões
        Pane paneButtons = new Pane();
        HBox boxBotoes = new HBox();
        //boxBotoes.setPrefHeight(100);
        //boxBotoes.setStyle("-fx-background-color: #fa6868;");
        paneButtons.setPadding (new Insets(16,16,16,16));
        paneButtons.getChildren().add(boxBotoes);

        // Criar os botoes
        Button botaoCalcular = new Button("Calcular");
//        botaoCalcular.setPrefHeight(100);
        Button botaoLimpar = new Button("Limpar");
//        botaoLimpar.setPrefHeight(50);
        Button botaoSair = new Button("Sair");
//        botaoSair.setPrefHeight(50);

        // Adicionar os botoes a caixa de botoes
        boxBotoes.getChildren().addAll(botaoCalcular,botaoLimpar,botaoSair);

        // Criar a caixa de resultado
        VBox boxResultado = new VBox();
        //boxResultado.setPrefHeight(300);
        //boxResultado.setStyle("-fx-background-color: #7bfa68;");

        // Criar os componentes da boxResultados
        Label labelResultado = new Label("Resultado: ");
        ListView listaTabuada = new ListView();
        labelResultado.setStyle("-fx-text-fill: red;-fx-font-size: 18; -fx-font-weight: bold");
        ListView listaTabuada2 = new ListView();



        // Adicionar os componentes ao boxResultados
        boxResultado.getChildren().addAll(labelResultado,listaTabuada);
        labelResultado.setPadding(new Insets(8,8,8,8));


        // Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(paneButtons);
        root.getChildren().add(boxResultado);
        root.getChildren().add(listaTabuada);


        // Colocamos a cena no palco
        stage.setScene(scene);

        // Coloca para mostrar o root
        stage.show();

        botaoCalcular.setOnAction(e -> {
            Usuario usuario = new Usuario();
            int multiplicando =
                    Integer.parseInt(textFieldMultiplicando.getText());
            //transformar a String em Int (o Integer.parseInt é oq faz para tranformar algo para outro)
            usuario.multiplicando = multiplicando;
            usuario.multiplicadorInicial =
                    Integer.parseInt(textFieldMenorMultiplicador.getText());
            usuario.multiplicadorFinal =
                    Integer.parseInt(textFieldMaiorMultiplicador.getText());

           String[] resultado = usuario.calcularTabuada();
           listaTabuada.getItems().addAll(resultado);
        });
        botaoLimpar.setOnAction(e -> {
            textFieldMaiorMultiplicador.setText("");
            textFieldMenorMultiplicador.setText("");
            textFieldMultiplicando.setText("");
            listaTabuada.getItems().clear();
            textFieldMultiplicando.requestFocus();
        });
        botaoSair.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Você quer sair do programa?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                System.exit(0);
            }
        });
    }
}
