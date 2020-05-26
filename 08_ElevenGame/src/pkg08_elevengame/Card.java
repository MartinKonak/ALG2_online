package pkg08_elevengame;

public class Card 
{
    public int val; //eso = 1, 2-10, j=11...
    public int symbol;//0 = srdce, 1 = kule, 2 = žalud, 3 = piky
    public String name;
    public Card(int val, int symbol){
        this.val = val;
        this.symbol = symbol;
        makeName();
    }
    private void makeName(){
        String sym="";
        name="";
        if(symbol==0){
            sym = "♥";
        }else if(symbol==1){
            sym = "♦";
        }else if(symbol==2){
            sym = "♣";
        }else if(symbol==3){
            sym = "♠";
        }if(val>1&&val<11)
            name=sym+val;
        else if (val==1)
            name=sym+"A";
        else if (val==11)
            name=sym+"J";
        else if (val==12)
            name=sym+"Q";
        else if (val==13)
            name=sym+"K";
        
    }
}