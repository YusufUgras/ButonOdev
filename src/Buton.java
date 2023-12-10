import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buton extends JButton {

    // Graphql Sema Adresini Tutan ozellik
    public String graphqlSchemaAddress;

    // Buton aktif oldugunda gosterilecek ikon
    private ImageIcon aktifIcon = new ImageIcon(getClass().getResource("/aktif.png"));

    // Buton pasif oldugunda gosterilecek ikon
    private ImageIcon pasifIkon = new ImageIcon(getClass().getResource("/pasif.png"));

    // Buton aktif oldugunda gosterilecek arkaplan rengi
    static Color aktifColor = Color.white;

    // Buton pasif oldugunda gosterilecek arkaplan rengi
    static Color pasifColor = Color.gray;

    // Anlik aktif olan butonu tutan static ozellik
    static Buton aktifButon;

    // Hayali mutation string i
    private String mutation = "mutation {\n" +
            "  insert_mutation_ornek(objects: [{ ozellik: \"Ozellik Degeri\" }]) {\n" +
            "    returning {\n" +
            "      id\n" +
            "    }\n" +
            "  }\n" +
            "}";

    Buton() {
        super(); // ust sinif constructoru cagriliyor text e ihtiyacimiz yok

        // olusturulan her buton baslangicta pasif olacak
        super.setIcon(pasifIkon);
        super.setBackground(pasifColor);

        // Hayali bir sema adresi tum butonlar icin gecerli istenirse degistirilebilir
        this.graphqlSchemaAddress = "orneksemaadresi.com";

        // Butona ActionListener Ekliyoruz
        super.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Eger halihazirda aktif button varsa onu pasif yap
                if (Buton.aktifButon != null) Buton.aktifButon.pasifYap();

                // Gecerli butonu aktif yap ve static degere ata
                Buton.aktifButon = Buton.this;
                Buton.aktifButon.aktifYap();

                // Hayali mutationun konsolda belirltilmesi
                System.out.println("Mutation calisti Adres : " + Buton.this.graphqlSchemaAddress + "\nMutation : " + Buton.this.mutation);
            }
        });

    }

    // Butonu aktif yapan method
    // Arkaplani ve ikonu aktif yap
    public void aktifYap() {
        this.setBackground(aktifColor);
        this.setIcon(aktifIcon);
    }

    // Butonu aktif yapan method
    // Arkaplani ve ikonu aktif yap
    public void pasifYap() {
        this.setBackground(pasifColor);
        this.setIcon(pasifIkon);
    }


}
