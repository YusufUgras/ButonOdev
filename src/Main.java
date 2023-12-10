import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 4x4 luk bir duzlem icin 16 tane buton olusturma
        // Bu butonlarin referansi ArrayList te tutulacaktir
        ArrayList<Buton> butonlar = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            butonlar.add(new Buton());
        }

        // Title ve layout ayarlama
        JFrame frame = new JFrame("Butonlar");
        frame.setLayout(new GridLayout(4, 4));

        // Olusturulan butonlarin hepsini frame e ekleme
        for (Buton buton : butonlar) {

            frame.add(buton);
        }

        // Belirli bir boyut ayarlama
        frame.setSize(800, 400);
        frame.setResizable(false);
        // Frame i gorunur hale getirip kapatma operation u belirltilmesi
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}