import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Deikstr {

    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();

        Item a = new Item("a");
        Item b = new Item("b");
        Item c = new Item("c");
        Item d = new Item("d");
        Item e = new Item("e");
        Item f = new Item("f");

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        a.getListNeighbors().put(b,3 );
        a.getListNeighbors().put(c, 2);

        b.getListNeighbors().put(c, 4);
        b.getListNeighbors().put(d, 1);
        b.getListNeighbors().put(e, 3);

        c.getListNeighbors().put(b, 4);
        c.getListNeighbors().put(d, 5);
        c.getListNeighbors().put(e, 2);

        d.getListNeighbors().put(e, 2);
        d.getListNeighbors().put(f, 4);

        e.getListNeighbors().put(d, 2);
        e.getListNeighbors().put(f, 6);

        deikste(list);


    }

    private static void deikste(List<Item> list) {
        printList(list);

        for(int i = 0; i < list.size(); i++ ){
            Item w = list.get(i);
            Item min;

            min = minNeighborFrom(w.getListNeighbors());
            List<Item> itemList = new ArrayList<>();
            itemList.add(min);
            printList(itemList);
           // deikste(itemList);
        }



    }

    private static Item minNeighborFrom(Map<Item, Integer> listNeighbors) {
        Item item = null;
        int start = 0;
        for (Map.Entry<Item, Integer> map : listNeighbors.entrySet()){

            if(item == null){
                item = map.getKey();
                start = map.getValue();
            } else {
                if(map.getValue() < start){
                    item  = map.getKey();
                    start = map.getValue();

                }

            }

        }
        System.out.println("min  "+ item.getName()+ "--" +start);
        return item;
    }

    private static void printList(List<Item> list) {
        for(int i = 0; i < list.size(); i++ ){
            Item w = list.get(i);
            if(w.getName().equals("f")) continue;
        for (Map.Entry<Item, Integer> map : w.getListNeighbors().entrySet()){
            System.out.println(w.getName()+" ---->> "+map.getKey().getName() +" --"+ map.getValue());


        }}
        System.out.println("----------------------------------------------");
    }
}
