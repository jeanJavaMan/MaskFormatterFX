/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.util;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author jeanderson Classe responsável para formatar campos de componentes
 * JAVAFX.
 */
public class MaskFormatter {

    /*Declaração dos componentes.*/
    private final TextField textField;
    /*Variavel que vai contem a mascara selecionada para caso seja exibido
    o formato da mascara.*/
    private int maskSelecionada;
    /*Declaração de constantes que vão representar os tipos de mascaras*/
    /**
     * Máscara de telefone com 8 digitos. ex: (61) 9340-6012.
     */
    public static final int TEL_8DIG = 0;
    /**
     * Máscara de telefone com 9 digitos. Ex: (61) 99340-6012
     */
    public static final int TEL_9DIG = 1;
    /**
     * Máscara de CPF. Ex: 000.000.000-00
     */
    public static final int CPF = 2;
    /**
     * Máscara de RG. EX: 00.000.000-0
     */
    public static final int RG = 3;

    /**
     * Passe o TextField que terá a mascara.
     *
     * @param textField
     */
    public MaskFormatter(TextField textField) {
        this.textField = textField;

    }

    /**
     * Passe o tipo da Mascara. Ex: setMask(MaskFormatter.TEL_8DIG);
     *
     * @param maskType
     */
    public void setMask(int maskType) {
        this.maskSelecionada = maskType;
        switch (maskType) {
            case TEL_8DIG:
                maskTel8Dig();
                break;
            case TEL_9DIG:
                maskTel9Dig();
                break;
            case CPF:
                maskCpf();
                break;
            case RG:
                maskRg();
                break;
            default:
                break;
        }
    }

    /**
     * Método que iniciar a mascara.
     */
    private void maskTel8Dig() {
        /*evento que captura os dados digitados*/
        textField.setOnKeyTyped((KeyEvent evento) -> {

            /*verifico se o que está sendo digitado é um numero*/
            if (!"0123456789".contains(evento.getCharacter())) {
                /*usando o método consume,e como se o que o usuario digitou não tivesse efeito, ex
                ele digitou uma letra, mas essa letra não apareçe pq bloqueamos o evento que faz ela aperecer na tela.*/
                evento.consume();
            }
            /*verificamos se o caracter foi digitado ou apagado se caso apagado ele é igual a zero.*/
            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 9:
                        /*subString so retornar os caracteres entre aquelas posições
                        fazemos isso para apagar o caractere - que colocamos na mascara.*/
                        textField.setText(textField.getText().substring(0, 8));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 1:
                        textField.setText("");
                        textField.positionCaret(textField.getText().length());
                        break;
                    default:
                        break;
                }

            } else if (textField.getText().length() == 14) {
                /*verificamos se já chegou o limite de numeros digitados
                lembrando que estamos contando todos os caracteres que estão visiveis*/

                evento.consume();
            }
            switch (textField.getText().length()) {
                case 1:
                    /*Adicionamos o parentese no primeiro caracter.Obs:
                    lembrando que cada caractere digitado e como se estivesse em um array
                    então o primeiro caracter fica na posição 0*/
                    textField.setText("(" + textField.getText());
                    /*movemos sempre a letra para o ultimo lugar, sem isso a letra voltaria para o primeiro*/
                    textField.positionCaret(textField.getText().length());
                    break;
                case 3:
                    /*como adicionamos um caractere parentese, aumenta mais um, então o segundo
                    numero digitado é o 3*/
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 9:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskTel9Dig() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 1:
                        textField.setText("");
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 10:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                }
            } else if (textField.getText().length() == 15) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 1:
                    textField.setText("(" + textField.getText());
                    textField.positionCaret(textField.getText().length());
                    break;
                case 3:
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskCpf() {

        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 11:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 7:
                        textField.setText(textField.getText().substring(0, 6));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                }

            } else if (textField.getText().length() == 14) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 3:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 7:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 11:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskRg() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 2:
                        textField.setText(textField.getText().substring(0, 1));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 6:
                        textField.setText(textField.getText().substring(0, 5));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 10:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                }

            } else if (textField.getText().length() == 12) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 2:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 6:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });

    }
    
    /**
     * Exibi no componente o formato de máscara selecionado.
     * Obs: Utilizar somente depois do método setMask()
     */
    public void showMask() {
        switch (this.maskSelecionada) {
            case TEL_8DIG:
                textField.setPromptText("(__) ____-____");
                break;
            case TEL_9DIG:
                textField.setPromptText("(__) _____-____");
                break;
            case CPF:
                textField.setPromptText("___.___.___-__");
                break;
            case RG:
                textField.setPromptText("__.___.___-_");
                break;
            default:
                break;
        }
    }
}
