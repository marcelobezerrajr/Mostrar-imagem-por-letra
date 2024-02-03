package java_projetos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MostrarImagemPorLetra extends JFrame implements ActionListener {
    private JLabel labelImagem;
    private JTextField textFieldLetra;
    private JButton botaoMostrar;
    private Map<Character, String> mapaImagens;

    public MostrarImagemPorLetra() {
        super("Mostra Imagem por Letra");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 1132);
        setLayout(new BorderLayout());

        inicializarMapaImagens();

        textFieldLetra = new JTextField();
        add(textFieldLetra, BorderLayout.NORTH);

        botaoMostrar = new JButton("Mostrar Imagem");
        botaoMostrar.addActionListener(this);
        add(botaoMostrar, BorderLayout.CENTER);

        labelImagem = new JLabel();
        add(labelImagem, BorderLayout.SOUTH);
    }

    private void inicializarMapaImagens() {
        mapaImagens = new HashMap<>();
        mapaImagens.put('A', "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbr.pinterest.com%2Fpin%2F371124825526173983%2F&psig=AOvVaw1CyZniyBWo0G29JgdqFe4i&ust=1706983791598000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPi2-aagjYQDFQAAAAAdAAAAABAE");    // Endereço da imagem
        mapaImagens.put('B', "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F686376799429095679%2F&psig=AOvVaw2CVuZWWE6ITm9KITuqaHLY&ust=1706983822756000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLjR1bagjYQDFQAAAAAdAAAAABAE");   // Endereço da imagem
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textoDigitado = textFieldLetra.getText().toUpperCase();
        if (textoDigitado.length() == 1) {
            char letra = textoDigitado.charAt(0);
            exibirImagem(letra);
        } else {
            JOptionPane.showMessageDialog(this, "Digite apenas uma letra.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirImagem(char letra) {
        labelImagem.setIcon(null);

        String caminhoDaImagem = mapaImagens.get(letra);

        if (caminhoDaImagem != null) {
            ImageIcon imagemIcone = new ImageIcon(caminhoDaImagem);
            labelImagem.setIcon(imagemIcone);
        } else {
            JOptionPane.showMessageDialog(this, "Imagem não encontrada para a letra: " + letra, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        MostrarImagemPorLetra janela = new MostrarImagemPorLetra();
        janela.setVisible(true);

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
