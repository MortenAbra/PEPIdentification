public class App {

    public static void main(String[] args) {
        //Defining PEP Finder object and defining filepath
        PEPFinder con = new PEPFinder("C:\\Users\\Mutten\\Desktop\\Programming stuff\\PEPIdentification\\src\\main\\resources\\PEP_list.xlsx");
        //Lookup for a specific person - Results in a hit
        boolean test = con.findPerson("Trine", "Bramsen");
        System.out.println(test);

        //Not a hit
        boolean test1 = con.findPerson("Lars", "Larsen");
        System.out.println(test1);
    }
}
