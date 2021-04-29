package hoegl.physikaufgabenGraph.model;

import com.arangodb.springframework.annotation.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Random;

@Document("Parameter")
@Getter @Setter @NoArgsConstructor
public class Parameter {

    @Id
    private String bezeichnungID;

    private String bezeichner;
    private String formelsymbol;
    private String einheit;
    private double zahlenwert;
    private double untereSchrankeZahlenwert;
    private double obereSchrankeZahlenwert;
    private boolean ganzeZahl;


    public Parameter(String bezeichner, String bezeichnungID, String einheit){
        this.bezeichner = bezeichner;
        this.bezeichnungID = bezeichnungID;
        this.einheit = einheit;
    }

    public Parameter(String formelsymbol, String bezeichnung, String bezeichner, String einheit, double zahlenwert, boolean ganzeZahl){
        this.formelsymbol = formelsymbol;
        this.bezeichnungID = bezeichnung;
        this.bezeichner = bezeichner;
        this.einheit = einheit;
        this.zahlenwert = zahlenwert;
        this.ganzeZahl = ganzeZahl;
    }

    public Parameter(String formelsymbol, String bezeichnung, String bezeichner, String einheit, double untereSchrankeZahlenwert, double obereSchrankeZahlenwert, boolean ganzeZahl){
        this.formelsymbol = formelsymbol;
        this.bezeichnungID = bezeichnung;
        this.bezeichner = bezeichner;
        this.einheit = einheit;
        this.untereSchrankeZahlenwert = untereSchrankeZahlenwert;
        this.obereSchrankeZahlenwert = obereSchrankeZahlenwert;
        this.ganzeZahl = ganzeZahl;

        this.generiereZahlenwert();
    }

    public void generiereZahlenwert(){
        Random r = new Random();
        if(ganzeZahl){
            zahlenwert = r.ints(1,(int) untereSchrankeZahlenwert, (int)obereSchrankeZahlenwert+1).findFirst().getAsInt();
        }else {
            zahlenwert = r.doubles(1, untereSchrankeZahlenwert, obereSchrankeZahlenwert+1).findFirst().getAsDouble();
        }
    }

    @Override
    public String toString(){
        if(isGanzeZahl()){
            return (int) zahlenwert + " " + einheit;
        } else {
            return String.format("%.2f", zahlenwert) + " " + einheit;
        }
    }

}
