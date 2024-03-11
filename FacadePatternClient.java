
import java.util.Scanner;

interface MoblieShope {
        public void modelNo();
        public void price();
}

class Samsung implements MoblieShope {
    @Override
    public void modelNo(){
        System.out.println("Samsung S27 Ultra");
    };
    @Override
    public void price(){
        System.out.println("1,00,000 Rs.");
    };
}

class Iphone implements MoblieShope {
    @Override
    public void modelNo(){
        System.out.println("iphone 14");
    };
    @Override
    public void price(){
        System.out.println("95,000 Rs.");
    };
}
class Blackberry implements MoblieShope {
    @Override
    public void modelNo(){
        System.out.println("BlackBerry 47S");
    }
    @Override
    public void price(){
        System.out.println("90,000 Rs.");
    };
}

class ShopKeeper {
    private MoblieShope iphone;
    private MoblieShope samsung;
    private MoblieShope blaclberry;
    ShopKeeper(){
        iphone = new Iphone();
        samsung = new Samsung();
        blaclberry = new Blackberry();
    }
    public void IphoneSale(){
        iphone.modelNo();
        iphone.price();
    }
    public void SamsungSale(){
        samsung.modelNo();
        samsung.price();
    }
    public void BlackberrySale(){
        blaclberry.modelNo();
        blaclberry.price();
    }

}


class FacadePatternClient {
    private static int choice;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ShopKeeper sk = new ShopKeeper();
        System.out.println("================ Moblie Shop ================");
        System.out.println("            1. IPHONE           \n");
        System.out.println("            2. SAMSUNG           \n");
        System.out.println("            3. BLACKBERRY           \n");
        System.out.println("            4. EXIT           \n");
        System.out.println("Enter your choice");
        choice = sc.nextInt();

        switch(choice){
            case 1:
                sk.IphoneSale();
                break;
            case 2:
                sk.SamsungSale();
                break;
            case 3:
                sk.BlackberrySale();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
        
    }
}