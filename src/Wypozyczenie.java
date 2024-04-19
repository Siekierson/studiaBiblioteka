import java.io.Serializable;
import java.util.Date;

public class Wypozyczenie implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idCzytelnika;
    private int idKsiazki;
    private Date dataWypozyczenia;
    private Date dataZwrotu;

    public Wypozyczenie(int idCzytelnika, int idKsiazki, Date dataWypozyczenia) {
        this.idCzytelnika = idCzytelnika;
        this.idKsiazki = idKsiazki;
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = null;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" +
                "idCzytelnika=" + idCzytelnika +
                ", idKsiazki=" + idKsiazki +
                ", dataWypozyczenia=" + dataWypozyczenia +
                ", dataZwrotu=" + dataZwrotu +
                '}';
    }

    public int getIdKsiazki() {
        return idKsiazki;
    }

    public Object getDataZwrotu() {
        return dataZwrotu;
    }
}
